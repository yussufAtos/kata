package com.kata.exceptions;

import com.kata.entities.DeliveryEnum;

public class DeliveryAlreadyExistsException extends RuntimeException {
    public DeliveryAlreadyExistsException(DeliveryEnum deliveryEnum) {
        super("Delivery Type " + deliveryEnum + " already exists");

    }
}
