package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.service.TicketService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("tickets")
@Produces({"application/json", "application/xml"})
public class TicketResource {


    TicketService ticketService = new TicketService();
    @GET
    public Response getTicket() {
        List<Ticket> tickets = ticketService.findAll();
        return Response.ok(tickets).build();
    }
    @GET
    @Path("/{id_ticket}")
    public Response getById(@PathParam("id_ticket") Long id_ticket) {
        Ticket ticket = ticketService.findOne(id_ticket);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Ticket non trouvé").build();
        }
        return Response.ok(ticket).build();
    }
    @POST
    public Response createTicket(Ticket ticket) {
        try {
            ticketService.createTicket(ticket);
            return Response.status(Response.Status.CREATED).entity(ticket).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Erreur lors de la création du ticket").build();
        }
    }
    @PUT
    @Path("/{id_ticket}")
    public Response updateTicket(@PathParam("id_ticket") Long id_ticket, Ticket updatedTicket) {
        Ticket existingTicket = ticketService.findOne(id_ticket);
        if (existingTicket == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Ticket non trouvé").build();
        }
        updatedTicket.setId_ticket(id_ticket);
        ticketService.updateTicket(updatedTicket);
        return Response.ok(updatedTicket).build();
    }
    @DELETE
    @Path("/{id_ticket}")
    public Response deleteTicket(@PathParam("id_ticket") Long id_ticket) {
        Ticket ticket = ticketService.findOne(id_ticket);
        if (ticket == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Ticket non trouvé").build();
        }
        ticketService.delete(ticket);
        return Response.status(Response.Status.NO_CONTENT).build();
    }


    @GET
    @Path("/statut/{statut}")
    public Response getTicketsByStatut(@PathParam("statut") String statut) {
        List<Ticket> tickets = ticketService.findTicketsByStatut(statut);
        return Response.ok(tickets).build();
    }


    @GET
    @Path("/evenement/{event_id}")
    public Response getTicketsByEvent(@PathParam("event_id") Long eventId) {
        List<Ticket> tickets = ticketService.findTicketsByEvent(eventId);
        return Response.ok(tickets).build();
    }
}
