package ru.liga.domain;

public class GetMatch {
    private final String id;
    private final Person person;

    public GetMatch(String id, Person person) {
        this.id = id;
        this.person = person;
    }

    public String getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }
}
