package com.microservices.ucan.restwebservice1.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	// for user not found to return 404 . ince final we can't override.
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<CommonErrorDescriptionComponent> handleUserNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
		CommonErrorDescriptionComponent error = new CommonErrorDescriptionComponent(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<CommonErrorDescriptionComponent>(error, HttpStatus.NOT_FOUND);
	}
	
	//this is for all errors - returns 500 . since final we can't override.
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CommonErrorDescriptionComponent> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		CommonErrorDescriptionComponent error = new CommonErrorDescriptionComponent(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<CommonErrorDescriptionComponent>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		// CommonErrorDescriptionComponent error = new CommonErrorDescriptionComponent(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); // this gives all default message + our custom message
		CommonErrorDescriptionComponent error = new CommonErrorDescriptionComponent(LocalDateTime.now(), ex.getFieldError().getDefaultMessage(), request.getDescription(false)); // gives custom message
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
