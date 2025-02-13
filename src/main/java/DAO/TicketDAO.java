package DAO;

import domain.Ticket;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jpa.EntityManagerHelper;

import java.util.List;

public class TicketDAO implements GenericDAO<Ticket,Long> {
    @Override
    public Ticket save(Ticket ticket) {
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        EntityManagerHelper.getEntityManager().persist(ticket);
        tx.commit();
        return ticket;
    }

    @Override
    public Ticket read(Long id) {
        return EntityManagerHelper.getEntityManager().find(Ticket.class, id);

    }

    @Override
    public Ticket update(Ticket ticket) {
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        Ticket r = EntityManagerHelper.getEntityManager().merge(ticket);
        tx.commit();
        return r;
    }

    @Override
    public void delete(Ticket ticket) {
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        EntityManagerHelper.getEntityManager().remove(ticket);
        tx.commit();
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




