package com.kata.dto;

import com.kata.entities.DeliveryEnum;

public class DeliveryRequest {
    private DeliveryEnum deliveryType;

    public DeliveryEnum getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryEnum deliveryType) {
        this.deliveryType = deliveryType;
    }

}
