package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.Client;
import ro.ubb.catalog.core.service.ClientService;
import ro.ubb.catalog.web.converter.ClientConverter;
import ro.ubb.catalog.web.dto.ClientDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientConverter clientConverter;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public Set<ClientDto> getClients() {
        List<Client> clients = clientService.getAllClients();
        Set<ClientDto> clientDtos = clientConverter.convertModelsToDtos(clients);
        return clientDtos;
    }


    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    ClientDto saveStudent(@RequestBody ClientDto dto) {
        return clientConverter.convertModelToDto(
                clientService.addClient(
                        clientConverter.convertDtoToModel(dto)
                )
        );
    }

//    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
//    ClientDto updateClient(@PathVariable Long id, @RequestBody ClientDto dto) {
//
//        return clientConverter.convertModelToDto(
//                clientService.updateClient(
//                        clientConverter.convertDtoToModel(dto)
//                ));
//    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.PUT)
    public ClientDto updateClient(
            @PathVariable final Long clientId,
            @RequestBody final ClientDto clientDto) {
        log.trace("updateClient: clientId={}, clientDtoMap={}", clientId, clientDto);

        Client client = new Client();
        // Setarea proprietăților clientului
        client.setId(clientId);
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setCity(clientDto.getCity());


        Client updatedClient = clientService.updateClient(client);

        ClientDto result = clientConverter.convertModelToDto(updatedClient);

        log.trace("updateClient: result={}", result);

        return result;
    }


    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}


