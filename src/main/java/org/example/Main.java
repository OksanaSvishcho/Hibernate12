package org.example;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        ClientCrudService clientService = new ClientCrudService(sessionFactory);
        PlanetCrudService planetService = new PlanetCrudService(sessionFactory);

        Client client = new Client();
        client.setName("John Doe");
        clientService.addClient(client);

        Client retrievedClient = clientService.getClient(client.getId());
        System.out.println("Retrieved Client: " + retrievedClient.getName());

        Planet planet = new Planet();
        planet.setId("MARS");
        planet.setName("Mars");
        planetService.addPlanet(planet);

        Planet retrievedPlanet = planetService.getPlanet("MARS");
        System.out.println("Retrieved Planet: " + retrievedPlanet.getName());

        updateClientExample(clientService);

        updatePlanetExample(planetService);

        deleteClientExample(clientService);

        deletePlanetExample(planetService);
    }

    public static void updateClientExample(ClientCrudService clientService) {
        Client client = clientService.getClient(1L);
        if (client != null) {
            client.setName("Updated John Doe");
            clientService.updateClient(client);
            System.out.println("Клієнта оновлено: " + client.getName());
        } else {
            System.out.println("Клієнта з таким id не знайдено.");
        }
    }

    public static void updatePlanetExample(PlanetCrudService planetService) {
        Planet planet = planetService.getPlanet("MARS");
        if (planet != null) {
            planet.setName("Updated Mars");
            planetService.updatePlanet(planet);
            System.out.println("Планету оновлено: " + planet.getName());
        } else {
            System.out.println("Планету з таким id не знайдено.");
        }
    }


    public static void deleteClientExample(ClientCrudService clientService) {
        Client client = clientService.getClient(1L);
        if (client != null) {
            clientService.deleteClient(client.getId());
            System.out.println("Клієнта видалено.");
        } else {
            System.out.println("Клієнта з таким id не знайдено.");
        }
    }

    public static void deletePlanetExample(PlanetCrudService planetService) {
        Planet planet = planetService.getPlanet("MARS");
        if (planet != null) {
            planetService.deletePlanet(planet.getId());
            System.out.println("Планету видалено.");
        } else {
            System.out.println("Планету з таким id не знайдено.");
        }
    }
}
