/**
 * 
 */
package demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.model.User;

/**
 * @author nikolapetrovic
 * @created Mar 17, 2015
 *
 */
@RestController
@RequestMapping("/users")
public class UserControler {
    private List<User> _users;

    public UserControler() {
	_users = new ArrayList<User>() {
	    {
		add(new User("1", "Nikola", "Petrovic", "nikola.petrovic"));
		add(new User("2", "Matija", "Vukomanovic", "matija.vukomanovic"));
		add(new User("3", "Andrijana", "Golubovska",
			"andrijan.golubovska"));
		add(new User("4", "Goran", "Gjorgoski", "goran.gjorgoski"));
		add(new User("5", "Andzela", "Stojanoska", "andzela.stojanoska"));
	    }
	};
    }

    @RequestMapping(value = "/user/{userId}")
    public User findById(@PathVariable String userId) {
	for (User user : _users) {
	    if (user.getId().equals(userId)) {
		return user;
	    }
	}
	return _users.get(2);
    }

    @RequestMapping(value = "/list")
    public List<User> list() {
	return _users;
    }
}
