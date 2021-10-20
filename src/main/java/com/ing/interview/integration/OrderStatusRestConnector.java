package com.ing.interview.integration;

import com.ing.interview.dto.OrderStatusDto;

public interface OrderStatusRestConnector {

	OrderStatusDto checkOrderStatus(Long id);

}