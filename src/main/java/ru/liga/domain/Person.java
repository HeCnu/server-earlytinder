package ru.liga.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Person")
public class Person {

    @Id
    private String id;

    private final String uniqueID;
    private final Boolean male;
    private final String login;
    private final String password;
    private String title;
    private List<String> likeList;
    public Person(String uniqueID, Boolean male, String login, String password, String title) {
        this.uniqueID = uniqueID;
        this.male = male;
        this.login = login;
        this.password = password;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public Boolean getMale() {
        return male;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLikeList() {
        return likeList;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLikeList(List<String> list) {
        this.likeList = list;
    }

    public void addLikeToList(String id) {
        likeList.add(id);
    }

    public void removeLikeFromList(String id) {
        likeList.remove(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                " id=" + uniqueID +
                ", male=" + male +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
