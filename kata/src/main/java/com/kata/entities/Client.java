package com.kata.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "selected_delivery_mode_id")
    private DeliveryMode selectedDeliveryMode;

    @ManyToMany
    @JoinTable(
        name = "client_time",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "houre_id")
    )
    private List<DeliveryTime> reservedHours = new ArrayList<>();

    
	public Client(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public Client() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public List<DeliveryTime> getReservedHours() {
		return reservedHours;
	}

	public void setReservedHours(List<DeliveryTime> reservedHours) {
		this.reservedHours = reservedHours;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DeliveryMode getSelectedDeliveryMode() {
		return selectedDeliveryMode;
	}

	public void setSelectedDeliveryMode(DeliveryMode selectedDeliveryMode) {
		this.selectedDeliveryMode = selectedDeliveryMode;
	}

}
