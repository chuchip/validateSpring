package com.profesorp.exception;


import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BeanNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(BeanNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	@ExceptionHandler(BeanDuplicateException.class)
	public final ResponseEntity<ExceptionResponse> handleBeanDuplicateException(BeanDuplicateException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false),HttpStatus.NOT_ACCEPTABLE.getReasonPhrase());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
	}
	  @Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			  HttpHeaders headers, HttpStatus status, WebRequest request) {
		    List<FieldError> l=ex.getBindingResult().getFieldErrors();
		    String msg=l.size()>0?l.get(0).getDefaultMessage():"";
		 
			ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
					"Error de validacion: "+   msg,
					request.getDescription(false),HttpStatus.BAD_REQUEST.getReasonPhrase());
			return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	  }
}
