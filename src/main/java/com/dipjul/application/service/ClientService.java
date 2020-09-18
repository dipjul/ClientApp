package com.dipjul.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dipjul.application.domain.Client;
import com.dipjul.application.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;

	public Client saveClient(Client client) {
		return repository.save(client);
	}


	public List<Client> getClients() {
		return repository.findAll();
	}

	public Client getClientById(int id) {
		return repository.findById(id).orElse(null);
	}

	public Client getClientByName(String name) {
		return repository.findByName(name);
	}

	public String deleteClient(int id) {
		repository.deleteById(id);
		return "Client with id: " + id + " removed";
	}

	public Client updateClient(Client newclient, int id) {
		return repository.findById(id).map(client -> {
			client.setName(newclient.getName());
	        client.setAddress(newclient.getAddress());
	        client.setPhone(newclient.getPhone());
	        client.setEmail(newclient.getEmail());
			return repository.save(client);
		}).orElseGet(() -> {
			newclient.setId(id);
			return repository.save(newclient);
		});
	}

}
