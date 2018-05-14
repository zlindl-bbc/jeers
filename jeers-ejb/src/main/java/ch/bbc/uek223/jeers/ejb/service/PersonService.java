package ch.bbc.uek223.jeers.ejb.service;


import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;

import java.util.List;

public interface PersonService {

    Event getEventById(long id);

    List<Person> getAllPerson();

    boolean login(Person person);

    void register(Person person);
}
