package com.ing.interview.integration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ColorPickerRestConnector {

	private static final Map<String, String> MAP = new HashMap<String, String>() {
		{
			put("AUDI", "WHITE");
			put("BMW", "GREY");
			put("MERCEDES", "GREY");
			put("FERRARI", "YELLOW");
			put("FIAT", "YELLOW");
			put("PEUGEOT", "BLUE");
			put("SEAT", "YELLOW");
		}
	};

	public Optional<String> pickColor(String model) {
		return Optional.ofNullable(MAP.get(model));
	}

}
