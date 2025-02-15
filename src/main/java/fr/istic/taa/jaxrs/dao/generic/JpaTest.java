package fr.istic.taa.jaxrs.dao.generic;



import fr.istic.taa.jaxrs.domain.Evenement;
import fr.istic.taa.jaxrs.domain.LastMinuteTicket;
import fr.istic.taa.jaxrs.domain.PremiumTicket;
import fr.istic.taa.jaxrs.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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
					Timestamp.valueOf(LocalDateTime.now()),
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




