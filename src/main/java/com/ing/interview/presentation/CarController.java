package com.ing.interview.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.interview.service.Car;
import com.ing.interview.service.CarCommand;
import com.ing.interview.service.CarService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

	private final CarService carService;

	@PostMapping
	public ResponseEntity<Car> create(@RequestBody CarCommand carCommand) {
		return ResponseEntity.ok(carService.create(carCommand));
	}

}
