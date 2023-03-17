package com.examen.springdemo.exception;

public class EmpleadoNotFoundException extends RuntimeException {
	
	   public EmpleadoNotFoundException(String message) {
	        super(message);
	    }

}
