package ru.liga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import ru.liga.domain.Person;
import ru.liga.service.PersonServiceCustom;

@RestController
public class PersonController {

    private final PersonServiceCustom personService;

    @Autowired
    public PersonController(PersonServiceCustom personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/persons", headers = "Accept=application/json")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping(value = "/persons")
    public void postPersonInPersons(@RequestBody Person person) {
        personService.createNewPerson(person);
    }

    @GetMapping(value = "/persons/{id}", headers = "Accept=application/json")
    public Person getPersonByUniqueID(@PathVariable String id) {
        return personService.getPersonByUniqueID(id);
    }

    @GetMapping(value = "/personsfor/{id}", headers = "Accept=application/json")
    public List<Person> getPersonsForLoggedPerson(@PathVariable String id) {
        return personService.getPersonsForLoggedPerson(id);
    }

}
