package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Producto;

public interface ProductoDAO {
	
	//se crean los metodos de la interface que tendrá la implementacion

	public List<Producto> getProductos();

	public void saveProducto(Producto theProducto);

	public Producto getProducto(int theId);

	public void deleteProducto(int theId);
	
}
