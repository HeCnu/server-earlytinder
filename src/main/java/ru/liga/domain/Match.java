package ru.liga.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Match")
public class Match {

    @Id
    private String id;
    private final String uniqueID;
    private List<Person> persons;

    public Match(String uniqueID, List<Person> persons) {
        this.uniqueID = uniqueID;
        this.persons = persons;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void addNewPerson(Person person) {
        persons.add(person);
    }
}
