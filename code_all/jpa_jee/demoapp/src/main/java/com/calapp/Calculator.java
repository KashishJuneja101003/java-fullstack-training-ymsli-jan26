package com.calapp;

public class Calculator {

	public int add(int i, int j) {
		return i+j;
	}

	public int divide(int i, int j) {
		if(j==0)
			throw new ArithmeticException("divide by zero");
		return i/j;
	}

}
