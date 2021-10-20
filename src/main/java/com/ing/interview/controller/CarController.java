package com.ing.interview.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.exception.ModelNotAvailableForColorPick;
import com.ing.interview.exception.OutOfStockException;
import com.ing.interview.service.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

	private final CarService service;

	@PostMapping
	public ResponseEntity<Car> create(@Validated @RequestBody CarDto carCommand)
	        throws OutOfStockException, ModelNotAvailableForColorPick {

		Car car = service.create(carCommand);

		return ResponseEntity.status(HttpStatus.CREATED)
		        .body(car);

	}

	@GetMapping("/id")
	public ResponseEntity<Car> get(@PathParam(value = "id") Long id) {

		Optional<Car> car = service.findById(id);

		return car.isPresent() ? ResponseEntity.ok(car.get())
		        : ResponseEntity.status(HttpStatus.NOT_FOUND)
		                .build();
	}

}
