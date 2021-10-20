package com.ing.interview.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.ing.interview.dto.CarDto;
import com.ing.interview.integration.InsuranceRestConnector;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InsuredValidator implements ConstraintValidator<CheckInsured, CarDto> {

	private final InsuranceRestConnector insuranceRestConnector;

	@Override
	public boolean isValid(CarDto value, ConstraintValidatorContext context) {
		return insuranceRestConnector.isEligible(value.getAge(), value.getModel());
	}
}
