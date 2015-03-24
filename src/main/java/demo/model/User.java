/**
 * 
 */
package demo.model;

import org.springframework.data.annotation.Id;

/**
 * @author nikolapetrovic
 * @created Mar 17, 2015
 *
 */
public class User {
    private String firstName;
    private String id;
    private String lastName;
    private String username;

    public User() {
	super();
    }

    public User(String firstName, String lastName, String username) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
    }

    public User(String id, String firstName, String lastName, String username) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
    }

    public String getFirstName() {
	return firstName;
    }

    @Id
    public String getId() {
	return id;
    }

    public String getLastName() {
	return lastName;
    }

    public String getUsername() {
	return username;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String toString() {
	return String.format(
		"User[id=%s, firstName='%s', lastName='%s', username='%s']",
		getId(), getFirstName(), getLastName(), getUsername());
    }
}
