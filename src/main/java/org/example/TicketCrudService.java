package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TicketCrudService {
    private final SessionFactory sessionFactory;

    public TicketCrudService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket createTicket(Client client, Planet fromPlanet, Planet toPlanet) {
        if (client == null || fromPlanet == null || toPlanet == null) {
            throw new IllegalArgumentException("Клієнт та планети не можуть бути null!");
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Ticket ticket = new Ticket();
            ticket.setClient(client);
            ticket.setFromPlanet(fromPlanet);
            ticket.setToPlanet(toPlanet);

            session.persist(ticket);

            session.getTransaction().commit();
            return ticket;
        }
    }

    public List<Ticket> getAllTickets() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }
}

