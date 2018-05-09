package ch.bbc.uek223.jeers.ejb.bean;


import ch.bbc.uek223.jeers.ejb.service.EventService;
import ch.bbc.uek223.jeers.entities.Event;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EventServiceImpl implements EventService {

    @PersistenceContext(unitName = "jeers")
    private EntityManager em;

    @Override
    public Event getEventById(long id) {
        return em.find(Event.class, id);
    }

    @Override
    public List<Event> getAllEvents() {
        return em.createNamedQuery("Event.findAll", Event.class).getResultList();
    }

    @Override
    public List<Event> getEventByName(String name) {
        return em.createNamedQuery("Event.findByName", Event.class).setParameter("name", name).getResultList();
    }

    @Override
    public void createEvent(Event event) {
       em.persist(event);
    }

    @Override
    public void deleteEvent(Event event) {
        em.remove(event);
    }

}
