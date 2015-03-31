package demo.model;

import org.springframework.data.annotation.Id;

/**
 * @author Matija.Vukomanovic
 * @created Mar 27, 2015
 *
 */
public class Contact {
    private String name;
    private String id;
    private String email;
    private String message;

    public Contact() {
	super();
    }

    public String getEmail() {
	return email;
    }

    @Id
    public String getId() {
	return id;
    }

    public String getMessage() {
	return message;
    }

    public String getName() {
	return name;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public void setName(String name) {
	this.name = name;
    }
}