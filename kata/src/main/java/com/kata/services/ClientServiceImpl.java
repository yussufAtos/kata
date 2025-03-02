package com.kata.services;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Service;
import com.kata.dao.ClientRepository;
import com.kata.dao.DeliveryModeRepository;
import com.kata.dao.DeliveryTimeRepository;
import com.kata.dto.ClientDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryEnum;
import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryTime;
import com.kata.exceptions.ClientNotFoundException;
import com.kata.exceptions.DeliveryNotFoundException;
import com.kata.exceptions.TimeNotFoundException;


@Service
public class ClientServiceImpl implements ClientService {

	private final ClientRepository clientRepository;
	private final DeliveryModeRepository deliveryModeRepository;
	private final DeliveryTimeRepository deliveryTimeRepository;

	public ClientServiceImpl(ClientRepository clientRepository, DeliveryModeRepository deliveryModeRepository,
			DeliveryTimeRepository deliveryTimeRepository) {
		this.clientRepository = clientRepository;
		this.deliveryModeRepository = deliveryModeRepository;
		this.deliveryTimeRepository = deliveryTimeRepository;
	}
	
	@Override
	public void createClient(ClientDto clientDto) {
		Client clientToSave = new Client(clientDto.name(), clientDto.email());
		clientRepository.save(clientToSave);
		
	}

	@Override
	public void createClientBooking(Long clientId, DeliveryEnum type, LocalDate date, LocalTime houre) {
		DeliveryMode deliveryMode = deliveryModeRepository.findByType(type)
				.orElseThrow(() -> new DeliveryNotFoundException(type));

		DeliveryTime deliveryTime = deliveryTimeRepository.findByDeliveryMode(deliveryMode).stream()
				.filter(time -> time.getDate().equals(date) && time.getDeliveryHour().equals(houre)).findFirst()
				.orElseThrow(() -> new TimeNotFoundException(date,houre));

		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ClientNotFoundException(clientId));

		client.setSelectedDeliveryMode(deliveryMode);
		client.getReservedHours().add(deliveryTime);
		clientRepository.save(client);
	}

}
