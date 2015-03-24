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

    @RequestMapping(value = "/user/{userId}")
    public User findById(@PathVariable String userId) {
	User user = getUserRepository().findOne(userId);
	return user;
    }

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public Map<String, String> createUser(@RequestBody User user) {
	System.out.println("########## user created @@@@@@@@@");
	Optional<User> existingUser = getUserRepository().findByUsername(
		user.getUsername());

	System.out.println();

	System.out.println(user);

	Map<String, String> map = new HashMap<>();
	map.put("status", "failed");

	return map;
    }

    @RequestMapping(value = "/list")
    public List<User> list() {
	return getUserRepository().findAll();
    }

    private UserRepository getUserRepository() {
	return _userRepository;
    }
}