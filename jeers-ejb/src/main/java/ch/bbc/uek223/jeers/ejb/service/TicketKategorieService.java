package ch.bbc.uek223.jeers.ejb.service;


import ch.bbc.uek223.jeers.entities.TicketKategorie;

import java.util.List;

public interface TicketKategorieService {

    TicketKategorie getTicketKategorieById(long id);

    List<TicketKategorie> getAllTicketKategorie();

    List<TicketKategorie> getAllTicketKategorieByName(String name);

    void createTicketKategorie(TicketKategorie ticketKategorie);

    void deleteTicketKategorie(TicketKategorie ticketKategorie);

    void updateTicketKategorie(TicketKategorie ticketKategorie);
}
