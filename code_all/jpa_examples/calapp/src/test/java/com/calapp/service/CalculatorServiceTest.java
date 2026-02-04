package com.calapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class CalculatorServiceTest {

	private final CalculatorService service = new CalculatorService();

	@Test
	void divide_shouldReturnQuotient_whenValidInputs() {
		int result = service.divide(10, 2);
		assertEquals(5, result);
	}

	@Test
	void divide_shouldThrowException_whenDivideByZero() {
		ArithmeticException ex = assertThrows(ArithmeticException.class, () -> service.divide(10, 0));

		assertEquals("Division by zero is not allowed", ex.getMessage());
	}

}
