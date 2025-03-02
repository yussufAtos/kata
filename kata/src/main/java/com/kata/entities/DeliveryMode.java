package com.kata.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "delivery_mode")
public class DeliveryMode {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private DeliveryEnum type;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "deliveryMode", cascade = CascadeType.MERGE)
    private Set<DeliveryTime> timeSlots;

    
	public DeliveryMode() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DeliveryEnum getType() {
		return type;
	}

	public void setType(DeliveryEnum type) {
		this.type = type;
	}

	public Set<DeliveryTime> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(Set<DeliveryTime> timeSlots) {
		this.timeSlots = timeSlots;
	}




}
