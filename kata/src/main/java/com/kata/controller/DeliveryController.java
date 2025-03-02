package com.kata.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.dao.ClientRepository;
import com.kata.dao.DeliveryModeRepository;
import com.kata.dto.ClientDto;
import com.kata.dto.DeliveryDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryEnum;
import com.kata.entities.DeliveryTime;
import com.kata.services.ClientService;
import com.kata.services.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

}
