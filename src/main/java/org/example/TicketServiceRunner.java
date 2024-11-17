package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class TicketServiceRunner {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory()) {

            TicketCrudService ticketService = new TicketCrudService(sessionFactory);
            ClientCrudService clientService = new ClientCrudService(sessionFactory);
            PlanetCrudService planetService = new PlanetCrudService(sessionFactory);

            Client client = clientService.getClient(1L); // Example: client with ID = 1
            if (client == null) {
                throw new IllegalArgumentException("Клієнт з ID 1 не знайдений!");
            }

            Planet earth = planetService.getPlanet("EARTH");
            Planet mars = planetService.getPlanet("MARS");
            if (earth == null || mars == null) {
                throw new IllegalArgumentException("Планети EARTH або MARS не знайдені!");
            }

            if (earth.equals(mars)) {
                throw new IllegalArgumentException("Початкова і кінцева планети не можуть бути однаковими!");
            }

            Ticket ticket = ticketService.createTicket(client, earth, mars);
            System.out.println("Квиток створено: ID = " + ticket.getId());

            List<Ticket> tickets = ticketService.getAllTickets();
            tickets.forEach(t -> System.out.println("Квиток ID: " + t.getId()));
        }
    }
}

