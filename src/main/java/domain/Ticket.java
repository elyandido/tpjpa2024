package domain;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_ticket", discriminatorType = DiscriminatorType.STRING)

public  abstract class Ticket {
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
