package com.ing.interview.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.ing.interview.infrastructure.CarRepository;
import org.junit.jupiter.api.Test;

class CarServiceTest {

    @Test
    void givenCommandWhenCreateThenExpectedValues(){
        // given
        CarCommand carCommand = CarCommand.builder()
            .age(16)
            .color("PINK")
            .model("BMW")
            .build();
        // given
        CarRepository carRepository = mock(CarRepository.class);
        CarService sut = new CarService(carRepository);

        // when
        final Car result = sut.create(carCommand);

        // then
        assertEquals("PINK", result.getColor());
        assertEquals("BMW", result.getModel());
    }

}