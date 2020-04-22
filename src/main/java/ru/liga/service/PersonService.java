package ru.liga.service;

import ru.liga.domain.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    List<Person> getPersonsForLoggedPerson(String id);

    void createNewPerson(Person pers);

    Person getPersonByUniqueID(String id);
}
