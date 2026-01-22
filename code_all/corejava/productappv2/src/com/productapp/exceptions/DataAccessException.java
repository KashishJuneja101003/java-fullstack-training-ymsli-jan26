package com.productapp.exceptions;

public class DataAccessException extends RuntimeException{
	private static final long serialVersionUID = 7252889684561599546L;

	public DataAccessException(String message, Throwable cause) {
		super(message, cause);
	}
}
