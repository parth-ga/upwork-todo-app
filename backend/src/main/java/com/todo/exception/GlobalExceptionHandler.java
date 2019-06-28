package com.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TodoException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(TodoException todoException) {
		ErrorResponse error = new ErrorResponse(todoException.getErrorCode(), todoException.getErrorMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

}
