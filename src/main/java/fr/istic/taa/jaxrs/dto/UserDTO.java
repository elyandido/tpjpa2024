package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Ticket;
import java.util.List;

public class UserDTO {
    private Long id_user;
    private String name;
    private String password;
    private String email;
    private List<Ticket> tickets;

    public UserDTO(Long Id_user,String name, String password, String email) {
        this.id_user = Id_user;
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public Long getId_user() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
