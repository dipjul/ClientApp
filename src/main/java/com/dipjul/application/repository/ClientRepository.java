package com.dipjul.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dipjul.application.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByName(String name);
}
