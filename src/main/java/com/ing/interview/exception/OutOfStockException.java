package com.ing.interview.exception;

public class OutOfStockException extends Exception {

	public OutOfStockException() {
		super("El modelo del coche elegido no tiene stock");
	}

}
