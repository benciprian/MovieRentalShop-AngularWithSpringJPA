package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client addClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);
}
