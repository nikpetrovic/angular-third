/**
 * 
 */
package demo.initializers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import demo.model.User;
import demo.repository.UserRepository;

/**
 * @author Nikola.Petrovic
 * @created Mar 24, 2015
 *
 */
@Component
@Profile("dev")
public class DevDbInitializer {
    @Autowired
    private UserRepository _userRepository;

    private UserRepository getUserRepository() {
	return _userRepository;
    }

    @PostConstruct
    public void initialize() {
	if (getUserRepository().count() == 0) {
	    getUserRepository().save(createUsers());
	}
    }

    private List<User> createUsers() {
	return new ArrayList<User>() {
	    {
		add(new User("Borche", "Alcinov", "borce.alcinov"));
		add(new User("Matija", "Vukomanovic", "matija.vukomanovic"));
		add(new User("Andrijana", "Golubovska", "andrijan.golubovska"));
		add(new User("Goran", "Gjorgoski", "goran.gjorgoski"));
		add(new User("Andzela", "Stojanoska", "andzela.stojanoska"));
		add(new User("Dejan", "Korcev", "dejan.korcev"));
		add(new User("Nikola", "Petrovic", "nikola.petrovic"));
	    }
	};
    }
}