package com.kata.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import com.kata.dto.ClientDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryEnum;

public interface ClientService {

	void createClient(ClientDto clientDto);
	void createClientBooking(Long clientId, DeliveryEnum type, LocalDate date, LocalTime houre);

}
