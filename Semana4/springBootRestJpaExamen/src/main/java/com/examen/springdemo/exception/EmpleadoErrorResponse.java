package com.examen.springdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpleadoErrorResponse {
	
	private int status;
    private String message;
    private long timeStamp;

}
