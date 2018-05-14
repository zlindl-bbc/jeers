package ch.bbc.uek223.jeers.ejb.service;


import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;

import java.util.List;

public interface PersonService {

    Event getEventById(long id);

    List<Person> getAllPerson();

    boolean login(String email, String passwort);

    void register(String vorname, String name, String email, String adresse, String ort, String passwort);
}
