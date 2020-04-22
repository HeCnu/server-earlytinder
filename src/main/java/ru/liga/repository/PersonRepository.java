package ru.liga.repository;

import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.liga.domain.Person;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findAll();
    Person findByUniqueID(String id);

}
