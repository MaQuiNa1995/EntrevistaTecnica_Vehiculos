package com.ing.interview.presentation;

import com.ing.interview.service.Car;
import com.ing.interview.service.CarCommand;
import com.ing.interview.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/car")
    public Car create(@RequestBody CarCommand carCommand) {
        return carService.create(carCommand);
    }

}
