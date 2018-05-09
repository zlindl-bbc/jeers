package ch.bbc.uek223.jeers.ejb.bean;


import ch.bbc.uek223.jeers.ejb.service.TicketKategorieService;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TicketKategorieServiceImpl implements TicketKategorieService {

    @PersistenceContext(unitName = "jeers")
    private EntityManager em;


    @Override
    public TicketKategorie getTicketKategorieById(long id) {
        return em.find(TicketKategorie.class, id);
    }

    @Override
    public List<TicketKategorie> getAllTicketKategorie() {
        return em.createNamedQuery("TicketKategorie.findAll").getResultList();
    }

    @Override
    public List<TicketKategorie> getAllTicketKategorieByName(String name) {
        return em.createNamedQuery("TicketKategorie.findByName").setParameter("name", name).getResultList();
    }

    @Override
    public void createTicketKategorie(TicketKategorie ticketKategorie) {
        em.persist(ticketKategorie);
    }

    @Override
    public void deleteTicketKategorie(TicketKategorie ticketKategorie) {
        em.remove(ticketKategorie);
    }

    @Override
    public void updateTicketKategorie(TicketKategorie ticketKategorie) {
        em.merge(ticketKategorie);
    }
}
