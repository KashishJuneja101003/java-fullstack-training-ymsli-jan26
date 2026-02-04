package com.calapp.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int mul(int a, int b) {
		return a*b;
	}
	
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
}