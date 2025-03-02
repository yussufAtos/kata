package com.kata.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kata.dto.ClientDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryEnum;
import com.kata.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientController {


}
