package ru.liga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.util.stream.Collectors;

import ru.liga.domain.Person;
import ru.liga.repository.PersonRepository;

public class PersonServiceCustom implements PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonServiceCustom.class);

    @Autowired
    private PersonRepository personRepository;

    private List<Person> personList;

    @Override
    public void createNewPerson(Person pers) {

        if (isHaveThisPerson(pers)) {
            Person person = personRepository.findByUniqueID(pers.getUniqueID());
            person.setLikeList(pers.getLikeList());
            person.setTitle(pers.getTitle());
            personRepository.save(person);
            logger.debug("Info about user [" + pers.getLogin() + "] is updated");
        } else {
            personRepository.insert(pers);
            logger.debug("User [" + pers.getLogin() + "] is created");
        }

        personList = personRepository.findAll();
    }

    @Override
    public List<Person> getAllPersons() {
        personList = personRepository.findAll();
        return personList;
    }

    @Override
    public Person getPersonByUniqueID(String id) {
        return personRepository.findByUniqueID(id);
    }

    @Override
    public List<Person> getPersonsForLoggedPerson(String id) {
        Person person = personRepository.findByUniqueID(id);
        List<Person> personsWithSomeGender = personList.stream().filter(x -> x.getMale() != person.getMale()).collect(Collectors.toList());
        List<Person> personsResult = new ArrayList<>();

        if (!person.getLikeList().isEmpty()) {
            for (Person pers: personsWithSomeGender) {
                int count = 0;
                for (String like : person.getLikeList()) {
                    if (pers.getUniqueID().equals(like))
                        count++;
                }
                if (count == 0)
                    personsResult.add(pers);
            }
        } else {
            personsResult = personsWithSomeGender;
        }

        return personsResult;
    }

    private Boolean isHaveThisPerson(Person person) {
        for (Person pers: personList) {
            if (pers.getLogin().equals(person.getLogin()) && pers.getPassword().equals(person.getPassword()))
                return true;
        }
        return false;
    }
}
