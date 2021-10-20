package com.ing.interview.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.ing.interview.dto.CarDto;
import com.ing.interview.entity.Car;
import com.ing.interview.exception.ModelNotAvailableForColorPick;
import com.ing.interview.exception.OutOfStockException;
import com.ing.interview.infrastructure.CarRepository;
import com.ing.interview.integration.CarAvailabilityRestConnector;
import com.ing.interview.integration.ColorPickerRestConnector;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

	private final CarRepository repository;
	private final CarAvailabilityRestConnector carAvailabilityRestConnector;
	private final ColorPickerRestConnector colorPickerRestConnector;

	@Override
	public Car create(CarDto dto) throws OutOfStockException, ModelNotAvailableForColorPick {

		String model = dto.getModel();
		String color = dto.getColor();

		this.chooseDefaultColor(dto);

		if (!carAvailabilityRestConnector.available(model, color)) {
			throw new OutOfStockException();
		}

		final Car car = Car.builder()
		        .color(color)
		        .model(model)
		        .build();

		return repository.save(car);
	}

	@Override
	public Optional<Car> findById(Long id) {
		return repository.findById(id);
	}

	private void chooseDefaultColor(CarDto dto) throws ModelNotAvailableForColorPick {

		if (!StringUtils.hasText(dto.getColor())) {
			String color = colorPickerRestConnector.pickColor(dto.getModel())
			        .orElseThrow(ModelNotAvailableForColorPick::new);
			dto.setColor(color);
		}
	}
}
