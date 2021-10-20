package com.ing.interview.integration;

import java.util.Optional;

public interface ColorPickerRestConnector {

	Optional<String> pickColor(String model);

}