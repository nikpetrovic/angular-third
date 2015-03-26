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

	Map<String, String> response = new HashMap<>();
	if (existingUser.isPresent()) {
	    response.put("status", "failed");
	    response.put("message", String.format(
		    "User with username '%s' already exists.",
		    user.getUsername()));
	} else {
	    getUserRepository().save(user);
	    response.put("status", "succeeded");
	    response.put("userId", user.getId());
	}

	return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Map<String, String> deleteUser(@RequestBody User user) {
	User existingUser = getUserRepository().findOne(user.getId());

	Map<String, String> response = new HashMap<>();
	if (existingUser == null) {
	    response.put("status", "failed");
	    response.put(
		    "message",
		    String.format("The user with id '%s' does not exist.",
			    user.getId()));
	} else if (existingUser.isSystemUser()) {
	    response.put("status", "failed");
	    response.put("message", "The system user cannot be deleted.");
	} else {
	    getUserRepository().delete(existingUser);
	    response.put("status", "succeeded");
	}

	return response;
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