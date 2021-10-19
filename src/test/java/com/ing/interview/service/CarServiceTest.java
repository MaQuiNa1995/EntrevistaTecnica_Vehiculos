package com.ing.interview.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ing.interview.InterviewApplication;
import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.infrastructure.CarRepository;
import com.ing.interview.integration.CarAvailabilityRestConnector;

@SpringBootTest(classes = InterviewApplication.class)
class CarServiceTest {

	@MockBean
	private CarRepository carRepository;

	@MockBean
	private CarAvailabilityRestConnector carAvailabilityRestConnector;

	@Autowired
	private CarService sut;

	@Test
	void givenCommandWhenCreateThenExpectedValues() {

		// mocks
		String color = "PINK";
		String model = "BMW";
		Mockito.when(carAvailabilityRestConnector.available(model, color))
		        .thenReturn(true);

		// given
		CarDto carCommand = CarDto.builder()
		        .age(16)
		        .color(color)
		        .model(model)
		        .build();

		// when
		Optional<Car> optionalCar = sut.create(carCommand);
		Assertions.assertTrue(optionalCar.isPresent());

		// then
		final Car result = optionalCar.get();
		Assertions.assertAll(() -> Assertions.assertEquals("PINK", result.getColor()),
		        () -> Assertions.assertEquals("BMW", result.getModel()));

		;

	}

}