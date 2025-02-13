package servlet;

import domain.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.EntityManagerHelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private EntityManager manager;

    @Override
    public void init() throws ServletException {
        this.manager = EntityManagerHelper.getEntityManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        List<Ticket> tickets = manager.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();


        out.println("<html><body>");
        out.println("<h1>Liste des Tickets</h1>");
        out.println("<ul>");
        for (Ticket ticket : tickets) {
            out.println("<li>Événement: " + ticket.getEvenement().getDescription() +
                    " - Utilisateur: " + ticket.getUser().getName() +
                    " - Prix: " + ticket.getPrice() +
                    " - Statut: " + ticket.getStatus() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String eventId = req.getParameter("eventId");
        String statut = req.getParameter("statut");
        String priceStr = req.getParameter("price");
        String typeTicket = req.getParameter("typeTicket"); // Récupère le type de ticket choisi

        if (userId != null && eventId != null && statut != null && priceStr != null && typeTicket != null) {
            Long userIdLong = Long.parseLong(userId);
            Long eventIdLong = Long.parseLong(eventId);
            double price = Double.parseDouble(priceStr);

            User user = manager.find(User.class, userIdLong);
            Evenement evenement = manager.find(Evenement.class, eventIdLong);

            if (user != null && evenement != null) {
                Ticket ticket;
                if ("PREMIUM".equals(typeTicket)) {
                    ticket = new PremiumTicket(price, statut, evenement, user, "Accès VIP");
                } else if ("LAST_MINUTE".equals(typeTicket)) {
                    ticket = new LastMinuteTicket(price, statut, evenement, user, 15.0);
                } else {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Type de ticket invalide");
                    return;
                }

                EntityTransaction tx = manager.getTransaction();
                tx.begin();
                manager.persist(ticket);
                tx.commit();
            }
        }

        // Redirection vers la liste des tickets
        resp.sendRedirect("/tickets");
    }

}

