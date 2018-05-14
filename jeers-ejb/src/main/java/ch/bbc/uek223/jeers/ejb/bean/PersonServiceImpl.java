package ch.bbc.uek223.jeers.ejb.bean;

import ch.bbc.uek223.jeers.ejb.service.PersonService;
import ch.bbc.uek223.jeers.entities.Event;
import ch.bbc.uek223.jeers.entities.Person;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PersonServiceImpl implements PersonService {

    @PersistenceContext(unitName = "jeers")
    private EntityManager em;

    @Override
    public Event getEventById(long id) {
        return em.find(Event.class, id);
    }

    @Override
    public List<Person> getAllPerson() {
        return em.createNamedQuery("Person.findAll", Person.class).getResultList();
    }

    @Override
    public boolean login(String email, String passwort) {
        if (em.createNamedQuery("Person.checkLogin", Person.class).setParameter("email", email)
                .setParameter("passwort", passwort) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void register(String vorname, String name, String email, String adresse, String ort, String passwort) {
        Person newPerson = new Person();
        newPerson.setVorname(vorname);
        newPerson.setName(name);
        newPerson.setEmail(email);
        newPerson.setAdresse(adresse);
        newPerson.setOrt(ort);
        newPerson.setPasswort(passwort);
        em.persist(newPerson);
    }
}
