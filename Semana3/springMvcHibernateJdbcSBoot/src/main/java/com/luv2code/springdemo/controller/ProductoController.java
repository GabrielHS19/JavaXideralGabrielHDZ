package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Producto;
import com.luv2code.springdemo.service.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	// need to inject our customer service
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/list")
	public String listProductos(Model theModel) {
		
		// get customers from the service
		List<Producto> theProductos = productoService.getProductos();
				
		// add the customers to the model
		theModel.addAttribute("productos", theProductos);
		
		return "list-productos";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Producto theProducto = new Producto();
		
		theModel.addAttribute("producto", theProducto);
		
		return "producto-form";
	}
	
	@PostMapping("/saveProducto")
	public String saveProducto(@ModelAttribute("producto") Producto theProducto) {
		
		// save the customer using our service
		productoService.saveProducto(theProducto);	
		
		return "redirect:/producto/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productoId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Producto theProducto = productoService.getProducto(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("producto", theProducto);
		
		// send over to our form		
		return "producto-form";
	}
	
	@GetMapping("/delete")
	public String deleteProducto(@RequestParam("productoId") int theId) {
		
		// delete the customer
		productoService.deleteProducto(theId);
		
		return "redirect:/producto/list";
	}
}










