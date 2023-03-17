package com.examen.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examen.springdemo.dao.EmpleadoDAO;
import com.examen.springdemo.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	@Qualifier("empleadoDAOJdbc")
	//@Qualifier("empleadoDAOJpa")
	private EmpleadoDAO empleadoDAO;
	
	@Override
	@Transactional
	public List<Empleado> getEmpleados() {
		return empleadoDAO.getEmpleados();
	}

	@Override
	@Transactional
	public Empleado saveEmpleado(Empleado theEmpleado) {

		Empleado empleado = empleadoDAO.saveEmpleado(theEmpleado);
		 return empleado;
	}

	@Override
	@Transactional
	public Empleado getEmpleado(int theId) {
		
		return empleadoDAO.getEmpleado(theId);
	}

	@Override
	@Transactional
	public void deleteEmpleado(int theId) {
		
		empleadoDAO.deleteEmpleado(theId);
	}
}





