package com.examen.springdemo.service;

import java.util.List;

import com.examen.springdemo.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> getEmpleados();

	public Empleado saveEmpleado(Empleado theEmpleado);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
