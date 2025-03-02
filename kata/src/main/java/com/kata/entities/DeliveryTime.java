package com.kata.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "time_delivery")
public class DeliveryTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalTime deliveryHour;


    @ManyToOne
    @JoinColumn(name = "delivery_mode_id", nullable = false)
    @JsonIgnore 
    private DeliveryMode deliveryMode;

    @ManyToMany(mappedBy = "reservedHours")
    private List<Client> customers = new ArrayList<>();

    
	public DeliveryTime() {
	}

	public DeliveryTime(LocalDate date, LocalTime deliveryHour) {
		super();
		this.date = date;
		this.deliveryHour = deliveryHour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getStartTime() {
		return deliveryHour;
	}

	public void setStartTime(LocalTime startTime) {
		this.deliveryHour = startTime;
	}

	public DeliveryMode getDeliveryMode() {
		return deliveryMode;
	}

	public void setDeliveryMode(DeliveryMode deliveryMode) {
		this.deliveryMode = deliveryMode;
	}

	public List<Client> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Client> customers) {
		this.customers = customers;
	}

	public LocalTime getDeliveryHour() {
		return deliveryHour;
	}

	public void setDeliveryHour(LocalTime deliveryHour) {
		this.deliveryHour = deliveryHour;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, deliveryHour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeliveryTime other = (DeliveryTime) obj;
		return Objects.equals(date, other.date) && Objects.equals(deliveryHour, other.deliveryHour);
	}


}
