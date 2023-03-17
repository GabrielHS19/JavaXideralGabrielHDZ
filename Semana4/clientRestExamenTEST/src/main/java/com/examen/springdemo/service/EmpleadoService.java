package com.examen.springdemo.service;

import java.util.List;

import com.examen.springdemo.entity.Empleado;
import com.examen.springdemo.entity.Empleado2;

public interface EmpleadoService {

	public List<Empleado> getEmpleados();

	public void saveEmpleado(Empleado2 theEmpleado);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
