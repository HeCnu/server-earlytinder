package ru.liga.service;

import ru.liga.domain.Person;

import java.util.List;

public interface MatchService {

    List<Person> getMatchesForSomePerson(String id);

    void addNewPersonsInMatchList(String id1, String id2);

}
