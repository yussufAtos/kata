package com.kata.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kata.dto.SlotsDto;
import com.kata.dto.DeliveryRequest;
import com.kata.services.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

	private final DeliveryService deliveryService;

	public DeliveryController(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

	@PostMapping
	public ResponseEntity<String> saveDelivery(@RequestBody DeliveryRequest deliveryType) {
		try {
			deliveryService.createDelivery(deliveryType);
			return ResponseEntity.status(HttpStatus.OK).body("Mode de livraison a bien eté ajoutée");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@PostMapping("/{deliveryId}/slots")
	public ResponseEntity<String> createSlotsForDelivery(@PathVariable Long deliveryId,
			@RequestBody SlotsDto slotsDto) {

		try {
			deliveryService.createSlotsForDelivery(deliveryId, slotsDto);
			return ResponseEntity.status(HttpStatus.OK).body("Mode de livraison a bien eté ajoutée");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
