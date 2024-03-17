package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    @Override
    public Client addClient(Client client) {
        return this.clientRepository.save(client);
    }


@Transactional
@Override
public Client updateClient(Client client) {
    Client clientToUpdate = this.clientRepository.findById(client.getId())
            .orElse(new Client());

    clientToUpdate.setFirstName(client.getFirstName());
    clientToUpdate.setLastName(client.getLastName());
    clientToUpdate.setEmail(client.getEmail());
    clientToUpdate.setPhoneNumber(client.getPhoneNumber());
    clientToUpdate.setCity(client.getCity());

    return clientToUpdate;
}

    @Override
    public void deleteClient(Long id) {
        this.clientRepository.deleteById(id);
    }
}
