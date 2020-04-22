package ru.liga.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import ru.liga.domain.Match;
import ru.liga.domain.Person;
import ru.liga.repository.MatchRepository;
import ru.liga.repository.PersonRepository;


public class MatchServiceCustom implements MatchService {

    private Logger logger = LoggerFactory.getLogger(MatchServiceCustom.class);

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Override
    public void addNewPersonsInMatchList(String id1, String id2) {
        Person person1 = personRepository.findByUniqueID(id1);
        Person person2 = personRepository.findByUniqueID(id2);

        addNewPersonInMatchList(id1, person2);
        addNewPersonInMatchList(id2, person1);
    }

    private void addNewPersonInMatchList(String id, Person person) {
        List<Person> tempList = new ArrayList<>();
        tempList.add(person);
        Match match = matchRepository.findByUniqueID(id);
        if (match == null) {
            matchRepository.insert(new Match(id, tempList));
            logger.debug("New match for user_id [" + id + "] is created");
        } else {
            match.getPersons().add(person);
            matchRepository.save(match);
            logger.debug("Match for user_id [" + id + "] is updated");
        }
    }

    @Override
    public List<Person> getMatchesForSomePerson(String id) {
        List<Person> matches = new ArrayList<>();
        try {
            return matchRepository.findByUniqueID(id).getPersons();
        } catch (Exception e) {
            return matches;
        }
    }

}
