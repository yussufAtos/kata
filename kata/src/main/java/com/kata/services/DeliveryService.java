package com.kata.services;

import com.kata.dto.SlotsDto;
import com.kata.dto.DeliveryRequest;
import com.kata.entities.DeliveryEnum;

public interface DeliveryService {

	void createDelivery(DeliveryRequest deliveryType);

	void createSlotsForDelivery(Long deliveryId, SlotsDto deliveryDto);

}
