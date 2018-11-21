package com.profesorp.exception;

public class BeanDuplicateException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BeanDuplicateException(String message) {
		super(message);
	}
}
