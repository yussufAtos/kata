package com.kata.exceptions;

import com.kata.entities.DeliveryEnum;

public class DeliveryNotFoundException extends RuntimeException{
	    public DeliveryNotFoundException(DeliveryEnum deliveryEnum) {
	    	 super("Delivery Type : " + deliveryEnum + " not found");
	    }

	}

