package demo.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Contact;
import demo.repository.ContactRepository;

/**
 * @author Matija.Vukomanovic
 * @created Mar 27, 2015
 *
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactRepository _contactRepository;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public Map<String, String> sendMessage(@RequestBody Contact contact) {

	Map<String, String> response = new HashMap<>();
	getContactRepository().save(contact);
	response.put("status", "succeeded");

	return response;
    }

    private ContactRepository getContactRepository() {
	return _contactRepository;
    }
}