package domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PREMIUM")
public class PremiumTicket extends Ticket {

    private String avantages;

    protected PremiumTicket() {}

    public PremiumTicket(double price, String statut, Evenement evenement, User user, String avantages) {
        super(price, statut, evenement, user);
        this.avantages = avantages;
    }

    public String getAvantages() {
        return avantages;
    }
}
