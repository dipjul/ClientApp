package com.dipjul.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dipjul.application.domain.Client;
import com.dipjul.application.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;

	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {
		return service.saveClient(client);
	}

	@GetMapping("/clients")
	public List<Client> findAllClients() {
		return service.getClients();
	}

	@GetMapping("/clients/{id}")
	public Client findClientById(@PathVariable int id) {
		return service.getClientById(id);
	}

	@PutMapping("/clients/{id}")
	Client replaceEmployee(@RequestBody Client newclient, @PathVariable int id) {
		return service.updateClient(newclient, id);

	}

	@DeleteMapping("/clients/{id}")
	public String deleteClient(@PathVariable int id) {
		return service.deleteClient(id);
	}
}
