package com.kata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	Client findByNameAndEmail(String name, String email);
}
