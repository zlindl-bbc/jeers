package ch.bbc.uek223.openair.entitytest;

import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class JPAUnitTest extends EntityManagerTest {

    private final String EVENT_NAME = "Gurtenfestival";
    private final String PERSON_NAME_ADMIN = "Admin";
    private final String TEST_EVENT = "TestEvent";


    @Test
    public void getEvent(){
        em.getTransaction().begin();
        List<Event> events = em.createNamedQuery("Event.findAll", Event.class).getResultList();
        em.getTransaction().commit();
        assertEquals(1, events.size());
        assertEquals(EVENT_NAME, events.get(0).getName());
    }

    @Test
    public void testIfPersonWithNameAdminExists() {
        em.getTransaction().begin();
        Person person = em.find(Person.class, 1L);
        em.getTransaction().commit();
        assertEquals(null, person);
    }

    @Test
    public void setNewEvent(){
        em.getTransaction().begin();
        List<Event> events = em.createNamedQuery("Event.findAll", Event.class).getResultList();
        int sizeBefore = events.size();

        Event event = new Event();
        event.setName(EVENT_NAME);
        em.persist(event);

        events = em.createNamedQuery("Event.findAll", Event.class).getResultList();
        em.getTransaction().commit();

        assertEquals((sizeBefore + 1), events.size());
    }
}
