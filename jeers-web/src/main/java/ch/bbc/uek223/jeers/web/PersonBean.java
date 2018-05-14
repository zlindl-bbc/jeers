package ch.bbc.uek223.jeers.web;


import ch.bbc.uek223.jeers.ejb.service.PersonService;
import ch.bbc.uek223.jeers.entities.Person;
import ch.bbc.uek223.jeers.util.FaceletMessage;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.logging.Logger;

@ManagedBean(name = "person")
@RequestScoped
public class PersonBean {

    @EJB
    private PersonService personService;

    private Person person = new Person();

    public String login() {
        Logger logger = Logger.getLogger(PersonBean.class.getName());
        logger.info(person.getEmail() + " " + person.getPasswort());
        String hashPasswort = Hashing.sha256().hashString(person.getPasswort(), Charsets.UTF_8).toString();
        if (personService.login(person.getEmail(), hashPasswort)) {
            FaceletMessage.showMessage(FacesContext.getCurrentInstance(),
                    FacesMessage.SEVERITY_INFO,
                    null,
                    "Login erfolgreich", null);
        } else {
            FaceletMessage.showMessage(FacesContext.getCurrentInstance(),
                    FacesMessage.SEVERITY_INFO,
                    null,
                    "Login fehlgeschlagen", null);
        }
        return "";
    }

    public String register() {
        String hashPasswort = Hashing.sha256().hashString(person.getPasswort(), Charsets.UTF_8).toString();
        personService.register(person.getVorname(), person.getName(), person.getEmail(), person.getAdresse(), person.getOrt(), hashPasswort);
        return "";
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
