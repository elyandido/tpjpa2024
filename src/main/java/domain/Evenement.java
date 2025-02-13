package domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Evenement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reference;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Column(nullable = false)
    private String location;

    private String description;

    private Double prix;

    @Column(name = "capacite", nullable = false)
    private int capacite;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private List<Ticket> tickets;

    protected Evenement() {}

    public Evenement(LocalDateTime date, String location, String description, Double prix, int capacite) {
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
