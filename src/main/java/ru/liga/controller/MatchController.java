package ru.liga.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.domain.Person;
import ru.liga.service.MatchService;
import ru.liga.service.MatchServiceCustom;
import ru.liga.service.PersonServiceCustom;

import java.util.List;

@RestController
public class MatchController {

    private final MatchServiceCustom matchService;

    @Autowired
    public MatchController(MatchServiceCustom matchService) {
        this.matchService = matchService;
    }

    @GetMapping(value = "/matches/{id}", headers = "Accept=application/json")
    public List<Person> getPersonMatches(@PathVariable String id) {
        return matchService.getMatchesForSomePerson(id);
    }

    @PostMapping(value = "/matches")
    public void postPersonMatches(@RequestBody List<String> match) {
        matchService.addNewPersonsInMatchList(match.get(0), match.get(1));
    }

}
