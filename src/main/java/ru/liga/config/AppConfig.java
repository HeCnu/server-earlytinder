package ru.liga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.liga.service.MatchServiceCustom;
import ru.liga.service.PersonServiceCustom;

@Configuration
public class AppConfig {

    @Bean
    public PersonServiceCustom personService() {
        return new PersonServiceCustom();
    }

    @Bean
    public MatchServiceCustom matchService() {
        return new MatchServiceCustom();
    }




}
