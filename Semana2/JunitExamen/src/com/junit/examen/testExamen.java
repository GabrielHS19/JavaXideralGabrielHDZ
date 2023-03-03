package com.junit.examen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class testExamen {
	
	// Se declaran los metodos beforeAll y aferAll para inicializar y cerrar los datos usados usados
	
	@BeforeAll
	static void antesEach(TestInfo prueba) {
		System.out.println("Inicializando datos: " + prueba.getDisplayName());
	}
	
	@AfterAll
	static void despuesEach(TestInfo info) {
		System.out.println("Cerrando los datos " + info.getDisplayName());
	}

	
	@Test
	@DisplayName("Conocer el costo final de una plancha ")
	void testPlancha() {
		//se declaran los objetos y metodos para realizar el test
		Compra comp = new Compra();
		comp.setClienteNombre("Mario");
		Inyector.inyectarPlancha(comp, 1500);
		//se hace el test 
        assertEquals(comp.getElectrodomestico().calcularPrecio(),1739.99,.01);
	}
	
	@Test
	@DisplayName("Conocer el costo final de una lavadora ")
	void testLavadora() {
		Compra comp = new Compra();
		comp.setClienteNombre("Pepe");
		Inyector.inyectarLavadora(comp, 10_500);
        assertEquals(comp.getElectrodomestico().calcularPrecio(),12180.0);
	}
	
	@Test
	@DisplayName("Conocer el costo final de una licuadora ")
	void testLicuadora() {
		Compra comp = new Compra();
		comp.setClienteNombre("Jose");
		Inyector.inyectarLicuadora(comp, 5_350);
        assertEquals(comp.getElectrodomestico().calcularPrecio(),6206.0);
	}
	
	@Test
	@DisplayName("Identificar que una lavadora se compró")
	void testNombreLavadora() {
		Compra comp = new Compra();
		comp.setClienteNombre("Tomas");
		Inyector.inyectarLavadora(comp, 5_350);
        assertEquals(comp.getElectrodomestico().devolverNombre(),"Lavadora");
	}
	
	@Test
	@DisplayName("Identificar que una licuadora se compró")
	void testNombreLicuadora() {
		Compra comp = new Compra();
		comp.setClienteNombre("Luis");
		Inyector.inyectarLicuadora(comp, 5_350);
        assertEquals(comp.getElectrodomestico().devolverNombre(),"Licuadora");
	}
	
	@Test
	@DisplayName("Identificar que una plancha se compró")
	void testNombrePlancha() {
		Compra comp = new Compra();
		comp.setClienteNombre("Gabriel");
		Inyector.inyectarPlancha(comp, 5_350);
        assertEquals(comp.getElectrodomestico().devolverNombre(),"Plancha");
	}

	@Test
	@DisplayName("Cuando no se inyecta la dependencia del electrodomestico hay una excepcion")
	void testFaltaElectrodomestico() {
		Compra comp = new Compra();
		comp.setClienteNombre("Jesus");
		assertThrows(NullPointerException.class, () -> comp.getElectrodomestico().calcularPrecio());
	}
}
