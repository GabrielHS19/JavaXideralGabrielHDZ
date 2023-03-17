package com.examen.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Empleado {


	private int id;
	
	private String nombre;
	
	private String email;
	
	private Double salario;
	
	private Departamento departamento;
	
	
}





