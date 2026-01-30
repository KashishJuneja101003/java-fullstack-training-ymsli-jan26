package com.traineemgtapp.exceptions;

public class ResourceNotFoundAcception extends RuntimeException{
	private static final long serialVersionUID = 3833190671998376790L;

	public ResourceNotFoundAcception(String message) {
		super(message);
	}
}
