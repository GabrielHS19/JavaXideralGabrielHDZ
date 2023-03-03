
package com.junit.examen;

public class Plancha implements Electrodomestico{
	
	private final String nombre ="Plancha";
	private double precio;
	

	@Override
	public double calcularPrecio() {
		return precio * 1.16;
	}

	@Override
	public String devolverNombre() {
		
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	    
    
}
