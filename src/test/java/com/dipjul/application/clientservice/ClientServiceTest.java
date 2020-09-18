package com.dipjul.application.clientservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//import com.dipjul.application.Application;
import com.dipjul.application.DemoApplication;
import com.dipjul.application.domain.Client;
import com.dipjul.application.service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class ClientServiceTest {

	@Autowired
	ClientService clientService;
	
	@Test
	public void findById_basics() {
		Client findById = clientService.getClientById(8);
//		Client result = new Client(1, "UnitedHealthCare", 2030000800, "contact@uhg.com", "US");
		assertEquals("UnitedHealthGroup", findById.getName());
		assertEquals(2030000888, findById.getPhone());
		assertEquals("care@uhg.com", findById.getEmail());
		assertEquals("US", findById.getAddress());
	}
	
	@Test
	@Transactional
	public void deleteById_basics() {
		clientService.deleteClient(10);
		assertNull(clientService.getClientById(10));
	}
	
	@Test
	@Transactional
	public void updateById_basics() {
		Client newClient = new Client("HyperCare", 9000005550L, "contact@hcare.com", "US");
		clientService.updateClient(newClient, 9);
		Client orgClient = clientService.getClientById(9);
		assertEquals("HyperCare", orgClient.getName());
		assertEquals(9000005550L, orgClient.getPhone());
		assertEquals("contact@hcare.com", orgClient.getEmail());
		assertEquals("US", orgClient.getAddress());
	}
	
	@Test
	@Transactional
	public void save_basics() {
		Client newClient = new Client("HyperCare", 9000005550L, "contact@hcare.com", "US");
		Client orgClient = clientService.saveClient(newClient);
		
		assertEquals(newClient.getName(), orgClient.getName());
		assertEquals(newClient.getEmail(), orgClient.getEmail());
		assertEquals(newClient.getPhone(), orgClient.getPhone());
		assertEquals(newClient.getAddress(), orgClient.getAddress());
	}

}
