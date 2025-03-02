package com.kata.dto;

import java.util.Set;

import com.kata.entities.DeliveryEnum;

public record SlotsDto(Set<TimeDeliveryDto> timeSlots) {

}
