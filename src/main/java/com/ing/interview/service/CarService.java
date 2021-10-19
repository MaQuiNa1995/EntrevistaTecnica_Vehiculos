package com.ing.interview.service;

import com.ing.interview.infrastructure.CarRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(CarCommand carCommand) {
        final Car car = Car.builder()
            .color(carCommand.getColor())
            .model(carCommand.getModel())
            .orderDate(LocalDate.now())
            .build();

        carRepository.save(car);

        return car;
    }

}
