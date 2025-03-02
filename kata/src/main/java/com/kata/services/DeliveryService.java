package com.kata.services;

import com.kata.dto.DeliveryDto;

public interface DeliveryService {

	void createDeliveryModeWithTime(DeliveryDto deliveryDto);

	void createDelivery(DeliveryDto deliveryDto);

}
