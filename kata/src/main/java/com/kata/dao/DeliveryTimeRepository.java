package com.kata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryTime;

@Repository
public interface DeliveryTimeRepository extends JpaRepository<DeliveryTime, Long> {
    List<DeliveryTime> findByDeliveryMode(DeliveryMode deliveryMode);
}