package jpa;


import domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {


	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
			EntityManager manager = EntityManagerHelper.getEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {

			User user1 = new User("Alice", "password123", "alice@email.com");
			manager.persist(user1);

			User user2 = new User("Bob", "securepass", "bob@email.com");
			manager.persist(user2);
			Evenement concert = new Evenement(
					LocalDateTime.of(2025, 6, 20, 20, 0),
					"Paris",
					"Concert de Coldplay",
					75.0,
					5000
			);

			manager.persist(concert);

			PremiumTicket premiumTicket = new PremiumTicket(150.0, "VENDU", concert, user1, "Accès VIP et boissons offertes");
			manager.persist(premiumTicket);

			LastMinuteTicket lastMinuteTicket = new LastMinuteTicket(50.0, "DISPONIBLE", concert, user1, 20.0);
			manager.persist(lastMinuteTicket);

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


   	 manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		System.out.println(".. done");
	}

	}




