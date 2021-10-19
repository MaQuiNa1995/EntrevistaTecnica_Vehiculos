package com.ing.interview.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDto {

	@NotNull
	private final Integer age;
	private final String color;
	@NotBlank
	private final String model;

}
