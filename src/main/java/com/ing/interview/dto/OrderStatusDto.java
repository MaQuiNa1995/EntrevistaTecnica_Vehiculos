package com.ing.interview.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderStatusDto {

	private final String assignedTo;
	private final LocalDateTime lastUpdate;
	private final String stage;

}
