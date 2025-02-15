package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.io.Serializable;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type_ticket")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PremiumTicket.class, name = "PREMIUM"),
        @JsonSubTypes.Type(value = LastMinuteTicket.class, name = "LAST_MINUTE")
})
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_ticket", discriminatorType = DiscriminatorType.STRING)

public  abstract class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_ticket;
    private double price;
    private String status;
    @ManyToOne
    @JoinColumn(name = "reference")
    private Evenement evenement;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    protected Ticket() {}

    public Ticket(double price, String status,Evenement evenement, User user) {
        this.id_ticket = id_ticket;
        this.price = price;
        this.status = status;
        this.evenement = evenement;
        this.user = user;

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

