package demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.model.Contact;

/**
 * @author Matija.Vukomanovic
 * @created Mar 27, 2015
 *
 */
public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findTop5ByOrderByDateCreatedDesc();
}