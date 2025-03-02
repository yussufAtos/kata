package com.kata.exceptions;

import com.kata.entities.DeliveryEnum;

public class SlotAlreadyReserved  extends RuntimeException{
	
    public SlotAlreadyReserved(String name) {
        super("slot is already reserved by : "+name);

    }
    

}
