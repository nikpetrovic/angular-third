/**
 * 
 */
package demo.model;

/**
 * @author nikolapetrovic
 * @created Mar 17, 2015
 *
 */
public class User {
    private String _firstName;
    private String _id;
    private String _lastName;
    private String _username;

    public User(String id, String firstName, String lastName, String username) {
	super();
	_id = id;
	_firstName = firstName;
	_lastName = lastName;
	_username = username;
    }

    public String getFirstName() {
	return _firstName;
    }

    public String getId() {
	return _id;
    }

    public String getLastName() {
	return _lastName;
    }

    public String getUsername() {
	return _username;
    }

    public void setFirstName(String firstName) {
	_firstName = firstName;
    }

    public void setId(String id) {
	_id = id;
    }

    public void setLastName(String lastName) {
	_lastName = lastName;
    }

    public void setUsername(String username) {
	_username = username;
    }
}
