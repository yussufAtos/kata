package com.kata.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryEnum;


public interface DeliveryModeRepository  extends JpaRepository<DeliveryMode, Long>{
	  Optional<DeliveryMode> findByType(DeliveryEnum type);
}
