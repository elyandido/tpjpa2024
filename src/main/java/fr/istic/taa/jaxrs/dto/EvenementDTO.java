package fr.istic.taa.jaxrs.dto;


import java.time.LocalDateTime;
import java.util.List;

public class EvenementDTO {

    private Long reference;
    private LocalDateTime date;
    private String location;

    private String description;

    private Double prix;


    private int capacite;


    private List<TicketDTO> tickets;

    protected EvenementDTO() {}

    public EvenementDTO(Long reference,LocalDateTime date, String location, String description, Double prix, int capacite) {
        this.date = date;
        this.location = location;
        this.description = description;
        this.prix = prix;
        this.capacite = capacite;
    }

    public Long getReference() {
        return reference;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrix() {
        return prix;
    }

    public int getCapacite() {
        return capacite;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }
}
