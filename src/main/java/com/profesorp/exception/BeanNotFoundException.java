package com.profesorp.exception;


public class BeanNotFoundException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BeanNotFoundException(String message) {
		super(message);
	}
}
