package com.examen.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examen.springdemo.entity.Departamento;
import com.examen.springdemo.entity.Empleado;
import com.examen.springdemo.entity.Empleado2;
import com.examen.springdemo.service.DepartamentoService;
import com.examen.springdemo.service.EmpleadoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

	// need to inject our customer service
	@Autowired
	private EmpleadoService empleadoService;
	private DepartamentoService departamentoService;
	Empleado emp = new Empleado();
	@GetMapping("/list")
	public String listEmpleados(Model theModel) {
		
		// get customers from the service
		List<Empleado> theEmpleados = empleadoService.getEmpleados();
				
		// add the customers to the model
		theModel.addAttribute("empleados", theEmpleados);
		
		return "list-empleados";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Empleado2 theEmpleado = new Empleado2();
		
		theModel.addAttribute("empleado2", theEmpleado);
		
		return "empleado-form";
	}
	
	@PostMapping("/saveEmpleado")
	public String saveEmpleado(@ModelAttribute("empleado2") Empleado2 theEmpleado) {
		
		empleadoService.saveEmpleado(theEmpleado);	
		
		return "redirect:/empleado/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("empleadoId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Empleado theEmpleado = empleadoService.getEmpleado(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("empleado2", theEmpleado);
		System.out.println(theEmpleado + "**************");
		int idDepa = theEmpleado.getDepartamento().getId();
		theModel.addAttribute("idDepa",idDepa);
		System.out.println(idDepa);
		// send over to our form		
		return "empleado-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmpleado(@RequestParam("empleadoId") int theId) {
		
		// delete the customer
		empleadoService.deleteEmpleado(theId);
		
		return "redirect:/empleado/list";
	}
	
	@RequestMapping("/listaDepartamento")
	@ResponseBody
	public List<Departamento> listaDepartamento(){
		return departamentoService.listaDepartamento();
	}
}










