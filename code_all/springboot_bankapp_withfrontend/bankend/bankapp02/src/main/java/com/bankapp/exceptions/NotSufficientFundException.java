package com.bankapp.exceptions;
public class NotSufficientFundException extends RuntimeException{

	private static final long serialVersionUID = 6115120847499794478L;

	public NotSufficientFundException(String message) {
		super(message);
	}
}