package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Ticket;
import fr.istic.taa.jaxrs.domain.User;
import jakarta.persistence.Query;

import java.util.List;

public class TicketDAO extends AbstractJpaDao<Long, Ticket>{

    public TicketDAO() {
        setClazz(Ticket.class);
    }

    public List<Ticket> findTicketsByStatut(String statut) {
        Query query = EntityManagerHelper.getEntityManager()
                .createQuery("SELECT t FROM Ticket t WHERE t.status = :statut", Ticket.class);
        query.setParameter("statut", statut);
        return query.getResultList();
    }


    public List<Ticket> findTicketsByEvent(Long reference) {

        Query query = EntityManagerHelper.getEntityManager()
                .createQuery("SELECT t FROM Ticket t WHERE t.evenement.reference = :reference", Ticket.class);
        query.setParameter("reference", reference);
        return query.getResultList();
    }
}
