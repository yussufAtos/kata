package com.kata.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.kata.dao.ClientRepository;
import com.kata.dao.DeliveryModeRepository;
import com.kata.dao.DeliveryTimeRepository;
import com.kata.dto.ClientDto;
import com.kata.entities.Client;
import com.kata.entities.DeliveryEnum;
import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryTime;
import com.kata.exceptions.ClientNotFoundException;
import com.kata.exceptions.DeliveryNotFoundException;
import com.kata.exceptions.TimeNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class ClientServiceImpl implements ClientService {



}
