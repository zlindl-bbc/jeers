package ch.bbc.uek223.jeers.ejb.service;


import ch.bbc.uek223.jeers.entities.Event;

import java.util.List;

public interface EventService {

    Event getEventById(long id);

    List<Event> getAllEvents();

    List<Event> getEventByName(String name);

    void createEvent(Event event);

    void deleteEvent(Event event);
}
