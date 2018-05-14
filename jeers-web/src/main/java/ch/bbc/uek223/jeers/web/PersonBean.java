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

    private String vorname;
    private String name;
    private String email;
    private String adresse;
    private String ort;
    private String passwort;

    public String login() {
        Logger logger = Logger.getLogger(PersonBean.class.getName());
        logger.info(getEmail() + " " + getPasswort());
        String hashPasswort = Hashing.sha256().hashString(getPasswort(), Charsets.UTF_8).toString();
        if (personService.login(getEmail(), hashPasswort)) {
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
        String hashPasswort = Hashing.sha256().hashString(getPasswort(), Charsets.UTF_8).toString();
        personService.register(getVorname(), getName(), getEmail(), getAdresse(), getOrt(), hashPasswort);
        return "";
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
