package com.examen.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.examen.springdemo.entity.Empleado;
import com.examen.springdemo.exception.EmpleadoNotFoundException;
import com.examen.springdemo.service.EmpleadoService;

@RestController
@RequestMapping("/rest")
public class EmpleadoController {

	// need to inject our customer service
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/empleados")
	public List<Empleado> findAll() {
		return empleadoService.getEmpleados();
	}
	
	@GetMapping("/empleados/{empleadoId}")
	public Empleado getEmpleado(@PathVariable int empleadoId) throws Exception {
		
		Empleado theEmpleado = empleadoService.getEmpleado(empleadoId);
		
		if (theEmpleado == null) {
			throw new EmpleadoNotFoundException("Empleado id not found - " + empleadoId);
		}
		
		return theEmpleado;
	}
	
	@PostMapping("/empleados")
	public Empleado addEmpleado(@RequestBody Empleado theEmpleado) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theEmpleado.setId(0);
		
		Empleado addEmpleado = empleadoService.saveEmpleado(theEmpleado);
		
		return addEmpleado;
	}
	
	@PutMapping("/empleados")
	public Empleado updateEmpleado(@RequestBody Empleado theEmpleado) {
		
		Empleado updEmpleado = empleadoService.saveEmpleado(theEmpleado);
		
		return updEmpleado;
	}
	
	@DeleteMapping("/empleados/{empleadoId}")
	public String deleteEmpleado(@PathVariable int empleadoId) {
		
		Empleado tempEmpleado = empleadoService.getEmpleado(empleadoId);
		
		// throw exception if null
		
		if (tempEmpleado == null) {
			throw new EmpleadoNotFoundException("Empleado id not found - " + empleadoId);
		}
		
		empleadoService.deleteEmpleado(empleadoId);
		
		return "Deleted empleado id - " + empleadoId;
	}
	
	
}










