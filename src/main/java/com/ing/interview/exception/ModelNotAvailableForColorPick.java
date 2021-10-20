package com.ing.interview.exception;

public class ModelNotAvailableForColorPick extends Exception {

	public ModelNotAvailableForColorPick() {
		super("El modelo del coche elegido no tiene un color por defecto, por favor introduce un color en la petición");
	}

}
