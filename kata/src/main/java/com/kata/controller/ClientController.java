package com.kata.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kata.dto.ClientDto;
import com.kata.entities.DeliveryEnum;
import com.kata.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {

	private final ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	public ResponseEntity<String> saveClient(@RequestBody ClientDto clientDto) {
		try {
			clientService.createClient(clientDto);
			return ResponseEntity.status(HttpStatus.OK).body("Le client a bien eté ajouté ");
		} catch (DataAccessException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}
	
	@PostMapping("/{clientId}/delivery/")
	public ResponseEntity<String> saveClientDelivery(@PathVariable Long clientId, @RequestParam DeliveryEnum typeDelivery,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime hour) {

		try {
			clientService.createClientBooking(clientId, typeDelivery, date, hour);
			return ResponseEntity.status(HttpStatus.OK).body("Le client a bien eté ajouté");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
