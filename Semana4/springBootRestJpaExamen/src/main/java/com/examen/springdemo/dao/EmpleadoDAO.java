package com.examen.springdemo.dao;

import java.util.List;

import com.examen.springdemo.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> getEmpleados();

	public Empleado saveEmpleado(Empleado theEmpleado);

	public Empleado getEmpleado(int theId);

	public void deleteEmpleado(int theId);
	
}
