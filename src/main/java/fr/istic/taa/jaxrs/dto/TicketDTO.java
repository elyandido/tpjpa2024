package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Evenement;
import fr.istic.taa.jaxrs.domain.User;
import jakarta.persistence.*;

public class TicketDTO {

    private Long id_ticket;
    private double price;
    private String status;
    private Evenement evenement;
    private User user;
    private String avantages;
    private double reduction;
    protected TicketDTO() {}
    // 🟢 Constructeur général pour un ticket générique
    public TicketDTO(Long id_ticket,double price, String status,Evenement evenement, User user) {
        this.id_ticket = id_ticket;
        this.price = price;
        this.status = status;
        this.evenement = evenement;
        this.user = user;

    }

    // 🟢 Constructeur général pour un ticket premium
    public TicketDTO(Long id_ticket,double price, String statut, Evenement evenement, User user, String avantages) {
        this(id_ticket,price, statut, evenement, user);
        this.avantages = avantages;
    }

    public String getAvantages() {
        return avantages;
    }
    // 🟢 Constructeur général pour un ticket lastminute
    public TicketDTO(Long id_ticket,double price, String statut, Evenement evenement, User user, double reduction) {
        this(id_ticket,price, statut, evenement, user);
        this.reduction = reduction;
    }

    public double getReduction() {
        return reduction;
    }

    public long getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(long id_ticket) {
        this.id_ticket = id_ticket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
