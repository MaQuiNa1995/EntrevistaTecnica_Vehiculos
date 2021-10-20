package com.ing.interview.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ing.interview.InterviewApplication;
import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.exception.ModelNotAvailableForColorPick;
import com.ing.interview.exception.OutOfStockException;
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
	void givenCommandWhenCreateThenExpectedValues() throws OutOfStockException, ModelNotAvailableForColorPick {

		// mocks
		String color = "PINK";
		String model = "BMW";
		Mockito.when(carAvailabilityRestConnector.available(model, color))
		        .thenReturn(true);

		final Car car = Car.builder()
		        .color(color)
		        .model(model)
		        .build();

		final Car carDb = Car.builder()
		        .id(1L)
		        .color(color)
		        .model(model)
		        .orderDate(LocalDate.now())
		        .build();

		Mockito.when(carRepository.save(car))
		        .thenReturn(carDb);

		// given
		CarDto carCommand = CarDto.builder()
		        .age(18)
		        .color(color)
		        .model(model)
		        .build();

		// when
		Car result = sut.create(carCommand);

		// then
		Assertions.assertAll(() -> Assertions.assertEquals("PINK", result.getColor()),
		        () -> Assertions.assertEquals("BMW", result.getModel()));

	}

}