package com.calapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest2 {
	
	private Calculator calculator;
	
	@BeforeEach
	public void beforeTest() {
		calculator=new Calculator();
		
	}
	@Test
	@DisplayName("test divide postive")
	public void divideTest() {
		assertEquals(2, calculator.divide(6,3));
	}
	
	@DisplayName("test divide with exception")
	@Test
	public void divideTwoNumberWithExceptionTest() {
		ArithmeticException ex 
		 = assertThrows(ArithmeticException.class, ()->calculator.divide(6, 0));
		
		assertEquals("divide by zero", ex.getMessage());
	}
	
	@Tag("prod")
	@Test
	//@Disabled
	@DisplayName("test add two numbers")
	public void addTest() {
		assertEquals(5, calculator.add(2,3));
	}
	
	@AfterEach
	public void afterTest() {
		calculator=null;
		
	}
}
