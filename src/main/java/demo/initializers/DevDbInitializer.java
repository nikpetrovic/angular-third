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
		// @formatter:off
		add(new User("Borche", "Alcinov", "borce.alcinov", null));
		add(new User("Matija", "Vukomanovic", "matija.vukomanovic", "A funny, attractive child with animal DNA and a body in the closet who is from the sea and lives with a magical being."));
		add(new User("Andrijana", "Golubovska", "andrijan.golubovska", null));
		add(new User("Goran", "Gjorgoski", "goran.gjorgoski", null));
		add(new User("Andzela", "Stojanoska", "andzela.stojanoska", null));
		add(new User("Dejan", "Korcev", "dejan.korcev", null));
		add(new User("Nikola", "Petrovic", "nikola.petrovic", "A mysterious, gorgeous old man with a human skull and a lust for power who is from a creepy city in by the ocean and lives with cannibals."));
		// @formatter:on
	    }
	};
    }
}