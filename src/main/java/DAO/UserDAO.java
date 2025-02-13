package DAO;

import domain.Ticket;
import domain.User;
import jakarta.persistence.EntityTransaction;
import jpa.EntityManagerHelper;

public class UserDAO implements GenericDAO<User, Long> {
    @Override
    public User save(User user) {

        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        EntityManagerHelper.getEntityManager().persist(user);
        tx.commit();
        return user;
    }

    @Override
    public User read(Long id) {
        return 	EntityManagerHelper.getEntityManager().find(User.class,id);
    }

    @Override
    public User update(User user) {
        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        User r = EntityManagerHelper.getEntityManager().merge(user);
        tx.commit();
        return user;
    }

    @Override
    public void delete(User user) {

        EntityTransaction tx = EntityManagerHelper.getEntityManager().getTransaction();
        EntityManagerHelper.getEntityManager().remove(user);
        tx.commit();
    }
}
