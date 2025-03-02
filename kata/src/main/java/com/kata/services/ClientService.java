package com.kata.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import com.kata.dto.ClientDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryEnum;

public interface ClientService {

	void saveClient(ClientDto clientDto);
	// void saveClientDelivery(Long customerId, DeliveryEnum deliveryEnum);
	void saveClientDelivery(Long clientId, DeliveryEnum type, LocalDate date, LocalTime houre);
	Optional<Client>  getClientById(Long id);
}
