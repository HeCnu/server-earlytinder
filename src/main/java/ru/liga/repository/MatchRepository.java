package ru.liga.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.liga.domain.Match;
import ru.liga.domain.Person;

import java.util.List;

public interface MatchRepository extends MongoRepository<Match, String> {

    List<Match> findAll();
    Match findByUniqueID(String id);

}
