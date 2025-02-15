package fr.istic.taa.jaxrs.service;

import fr.istic.taa.jaxrs.dao.generic.TicketDAO;
import fr.istic.taa.jaxrs.domain.Ticket;

import java.util.List;

public class TicketService {
    private final TicketDAO ticketDAO;

    public TicketService() {
        this.ticketDAO = new TicketDAO();
    }

   public void createTicket(Ticket ticket) {ticketDAO.save(ticket);}

    public Ticket updateTicket(final Ticket ticket) {ticketDAO.update(ticket); return ticket;}

    public void delete (Ticket ticket) {ticketDAO.delete(ticket);}

    public Ticket findOne(Long id) {return ticketDAO.findOne(id);}

    public List<Ticket> findAll() {return ticketDAO.findAll();}

    public List<Ticket> findTicketsByEvent(Long id_ticket) {return ticketDAO.findTicketsByEvent(id_ticket);}

    public List<Ticket> findTicketsByStatut(String statut) {return ticketDAO.findTicketsByStatut(statut);}
}
