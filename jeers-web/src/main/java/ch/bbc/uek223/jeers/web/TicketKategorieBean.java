package ch.bbc.uek223.jeers.web;

import ch.bbc.uek223.jeers.ejb.service.TicketKategorieService;
import ch.bbc.uek223.jeers.entities.TicketKategorie;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "ticketKategorie")
@RequestScoped
public class TicketKategorieBean {

    @EJB
    private TicketKategorieService ticketKategorieService;
    private List<TicketKategorie> ticketList;

    @PostConstruct
    public void init(){
        ticketList = ticketKategorieService.getAllTicketKategorie();
    }

    public List<TicketKategorie> ticketList() {
        return ticketList;
    }
}
