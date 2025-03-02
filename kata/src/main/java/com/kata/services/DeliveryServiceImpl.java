package com.kata.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.kata.dao.DeliveryModeRepository;
import com.kata.dto.SlotsDto;
import com.kata.dto.DeliveryRequest;
import com.kata.dto.TimeDeliveryDto;
import com.kata.entities.DeliveryMode;
import com.kata.entities.DeliveryTime;
import com.kata.exceptions.DeliveryAlreadyExistsException;
import com.kata.exceptions.DeliveryNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	private final DeliveryModeRepository deliveryModeRepository;

	public DeliveryServiceImpl(DeliveryModeRepository deliveryModeRepository) {
		this.deliveryModeRepository = deliveryModeRepository;
	}

	@Override
	public void createDelivery(DeliveryRequest deliveryType) {

		Optional<DeliveryMode> deliveryMode = deliveryModeRepository.findByType(deliveryType.getDeliveryType());
		if (deliveryMode.isPresent())
			throw new DeliveryAlreadyExistsException(deliveryType.getDeliveryType());

		DeliveryMode deliveryModeToSave = new DeliveryMode();
		deliveryModeToSave.setType(deliveryType.getDeliveryType());
		deliveryModeRepository.save(deliveryModeToSave);
	}

	@Override
	@Transactional
	public void createSlotsForDelivery(Long deliveryId, SlotsDto deliveryDto) {
		Optional<DeliveryMode> deliveryMode = deliveryModeRepository.findById(deliveryId);
		if (deliveryMode.isEmpty()) {
			throw new DeliveryNotFoundException(deliveryId);
		} else {

			Set<DeliveryTime> deliveryTimeList = deliveryDto.timeSlots().stream()
					.filter((time) -> extractedSlot(deliveryMode, time)).map((cr) -> {
						DeliveryTime deliveryTime = new DeliveryTime();
						deliveryTime.setDate(cr.date());
						deliveryTime.setDeliveryHour(cr.deliveryHour());
						deliveryTime.setDeliveryMode(deliveryMode.get());
						return deliveryTime;
					}).collect(Collectors.toSet());

			deliveryMode.get().setTimeSlots(deliveryTimeList);
			deliveryModeRepository.save(deliveryMode.get());
		}

	}

	private boolean extractedSlot(Optional<DeliveryMode> deliveryMode, TimeDeliveryDto time) {
		return !deliveryMode.get().getTimeSlots().contains(new DeliveryTime(time.date(), time.deliveryHour()));
	}
}
