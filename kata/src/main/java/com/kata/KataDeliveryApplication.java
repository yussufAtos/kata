package com.kata;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kata.dao.ClientRepository;
import com.kata.dao.DeliveryModeRepository;
import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryEnum;

@SpringBootApplication
public class KataDeliveryApplication  {

	public static void main(String[] args) {
		SpringApplication.run(KataDeliveryApplication.class, args);
	}

}
