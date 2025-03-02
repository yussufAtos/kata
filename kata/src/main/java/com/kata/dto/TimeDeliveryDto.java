package com.kata.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record TimeDeliveryDto(LocalDate date, LocalTime deliveryHour) {

}
