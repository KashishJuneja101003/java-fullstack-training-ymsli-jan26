package com.productapp.exceptions;

public class ServiceException extends RuntimeException{
	private static final long serialVersionUID = 7252889684561599546L;

	public ServiceException(String message, Throwable e) {
		super(message,e );
	}
}
