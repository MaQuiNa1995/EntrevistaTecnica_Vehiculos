package com.ing.interview.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ing.interview.controller.validator.CheckInsured;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@CheckInsured
public class CarDto {

	@NotNull
	@Min(18)
	private Integer age;
	private String color;
	@NotBlank
	private String model;

}
