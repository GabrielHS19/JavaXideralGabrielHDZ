package com.junit.examen;

public class principal {

	public static void main(String[] args) {
		Compra comp = new Compra();
		//comp.setClienteNombre("Pepe");
		System.out.println(comp.getElectrodomestico().calcularPrecio());
		System.out.println(comp.getElectrodomestico());

	}

}
