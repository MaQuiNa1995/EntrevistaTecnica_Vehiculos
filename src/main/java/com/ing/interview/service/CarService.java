package com.ing.interview.service;

import java.util.Optional;

import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.exception.ModelNotAvailableForColorPick;
import com.ing.interview.exception.OutOfStockException;

public interface CarService {

	Car create(CarDto dto) throws OutOfStockException, ModelNotAvailableForColorPick;

	Optional<Car> findById(Long id);

}