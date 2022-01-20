package org.packageandplan.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFouneException
			(ResourceNotFoundException ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails
				(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> GlobleExceptionHandler
				(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails
				(new Date(), ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}