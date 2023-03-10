package com.luv2code.springdemo.service;

import java.util.List;
import com.luv2code.springdemo.entity.Producto;

public interface ProductoService {
	
	//Se definen los metodos que serán heredados del service

	public List<Producto> getProductos();

	public void saveProducto(Producto theProducto);

	public Producto getProducto(int theId);

	public void deleteProducto(int theId);
	
}
