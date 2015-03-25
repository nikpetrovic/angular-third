/**
 * 
 */
package demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.User;
import demo.repository.UserRepository;

/**
 * @author nikolapetrovic
 * @created Mar 17, 2015
 *
 */
@RestController
@RequestMapping("/users")
public class UserControler {
    @Autowired
    private UserRepository _userRepository;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public Map<String, String> createUser(@RequestBody User user) {
	Optional<User> existingUser = getUserRepository().findByUsername(
		user.getUsername());

	Map<String, String> map = new HashMap<>();
	if (existingUser.isPresent()) {
	    map.put("status", "failed");
	    map.put("message", String.format(
		    "User with username '%s' already exists.",
		    user.getUsername()));
	} else {
	    getUserRepository().save(user);
	    map.put("status", "succeeded");
	}

	return map;
    }

    @RequestMapping(value = "/user/{userId}")
    public User findById(@PathVariable String userId) {
	User user = getUserRepository().findOne(userId);
	return user;
    }

    @RequestMapping(value = "/list")
    public List<User> list() {
	return getUserRepository().findAll();
    }

    private UserRepository getUserRepository() {
	return _userRepository;
    }
}