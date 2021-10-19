package com.ing.interview.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.service.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

	private final CarService carService;

	@PostMapping
	public ResponseEntity<Car> create(@RequestBody CarDto carCommand) {

		Optional<Car> optionalCar = carService.create(carCommand);

		return optionalCar.isPresent() ? ResponseEntity.status(HttpStatus.CREATED)
		        .body(optionalCar.get())
		        : ResponseEntity.status(HttpStatus.NO_CONTENT)
		                .build();
	}
}
