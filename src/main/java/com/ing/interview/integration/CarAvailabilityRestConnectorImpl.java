package com.ing.interview.integration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CarAvailabilityRestConnectorImpl implements CarAvailabilityRestConnector {

	private static final Set<String> STOCK = new HashSet<String>() {
		{
			add("PEUGEOT:BLUE");
			add("FIAT:YELLOW");
			add("MERCEDES:BLACK");
		}
	};

	@Override
	public boolean available(String model, String color) {
		String colorModel = model + ":" + color;

		return STOCK.contains(colorModel);
	}

}
