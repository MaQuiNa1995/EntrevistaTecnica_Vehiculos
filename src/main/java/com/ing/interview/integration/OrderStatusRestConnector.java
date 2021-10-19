package com.ing.interview.integration;

import java.time.LocalDateTime;

import com.ing.interview.dto.OrderStatusDto;

public class OrderStatusRestConnector {

	public OrderStatusDto checkOrderStatus(Long id) {
		return id % 2 == 0 ? OrderStatusDto.builder()
		        .assignedTo("Sergi")
		        .stage("processing")
		        .lastUpdate(LocalDateTime.now())
		        .build()
		        : OrderStatusDto.builder()
		                .assignedTo("Tomas")
		                .stage("pending")
		                .lastUpdate(LocalDateTime.now())
		                .build();
	}

}
