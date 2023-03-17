package com.examen.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmpleadoRestExceptionHandler {
	
	@ExceptionHandler
    public ResponseEntity<EmpleadoErrorResponse> handleException(EmpleadoNotFoundException exc) {

        // create a CustomerErrorResponse

		EmpleadoErrorResponse error = new EmpleadoErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler
    public ResponseEntity<EmpleadoErrorResponse> handleException(Exception exc) {

        // create a CustomerErrorResponse
		EmpleadoErrorResponse error = new EmpleadoErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
