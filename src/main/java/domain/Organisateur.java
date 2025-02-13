package domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Organisateur {
     @Id
    @GeneratedValue
    Long id;
     String name;
     String email;
     String password;
}
