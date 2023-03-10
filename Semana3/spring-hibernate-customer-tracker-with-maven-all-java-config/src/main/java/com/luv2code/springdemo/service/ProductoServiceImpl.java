package com.luv2code.springdemo.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProductoDAO;
import com.luv2code.springdemo.entity.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	// se declara un costumer dao
	@Autowired
	private ProductoDAO productoDAO;
	
	//se declaran los metodos heredados
	
	@Override
	@Transactional
	public List<Producto> getProductos() {
		//se retornan los valores 
		return productoDAO.getProductos();
	}

	@Override
	@Transactional
	public void saveProducto(Producto theProducto) {
		//se declara la fecha y se le asigna al producto
		Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
		theProducto.setFecha(fecha);
		productoDAO.saveProducto(theProducto);
	}

	@Override
	@Transactional
	public Producto getProducto(int theId) {
		//se retorna el producto mediante el id
		return productoDAO.getProducto(theId);
	}

	@Override
	@Transactional
	public void deleteProducto(int theId) {
		//se elimina el producto mediante el id
		productoDAO.deleteProducto(theId);
	}
}





