package domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LAST_MINUTE")
public class LastMinuteTicket extends Ticket {

    private double reduction;

    protected LastMinuteTicket() {}

    public LastMinuteTicket(double price, String statut, Evenement evenement, User user, double reduction) {
        super(price, statut, evenement, user);
        this.reduction = reduction;
    }

    public double getReduction() {
        return reduction;
    }
}
