package com.ing.interview.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.infrastructure.CarRepository;
import com.ing.interview.integration.CarAvailabilityRestConnector;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarService {

	private final CarRepository carRepository;
	private final CarAvailabilityRestConnector carAvailabilityRestConnector;

	public Optional<Car> create(CarDto carCommand) {

		String color = carCommand.getColor();
		String model = carCommand.getModel();

		if (!carAvailabilityRestConnector.available(model, color)) {
			return Optional.empty();
		}

		final Car car = Car.builder()
		        .color(color)
		        .model(model)
		        .orderDate(LocalDate.now())
		        .build();

		carRepository.save(car);

		return Optional.of(car);
	}
}
