/**
 * 
 */
package demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.model.User;

/**
 * @author Nikola.Petrovic
 * @created Mar 24, 2015
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
