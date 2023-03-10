package com.lambdas.examen;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.ArrayList;

public class Principal {

	// Creamos una lista de productos
	private static List<Producto> productos = new ArrayList<>();

	public static void main(String[] args) {

		// Agregamos algunos productos a la lista mediante constructor
		productos.add(new Producto(1, "Leche", 10.0, 20));
		productos.add(new Producto(2, "Pan tostado", 20.0, 30));
		productos.add(new Producto(3, "Chocolate", 30.0, 43));

		// Se imprime la lista de productos
		getProductos();

		// Se busca por id un producto
		int productoId = 3;
		System.out.println("Buscando producto con el id " + productoId);
		Producto producto = getProducto(productoId);
		System.out.println("Producto encontrado: " + producto);
		System.out.println();

		// Se elimina un producto de la lista
		System.out.println("Eliminando producto " + productoId + "...");
		deleteProducto(productoId);
		getProductos();

		// se agrega un producto y se modifica su precio por medio de lambda consumer
		Producto e = new Producto(4, "Azucar", 50.0, 33);
		Consumer<Producto> con2 = pro -> pro.setPrecio(pro.getPrecio() + 100);
		con2.accept(e);
		addProducto(e);
		getProductos();

		// se agrega un producto usando el lambda unaryOperator
		UnaryOperator<Producto> prod = p -> {
			p.setId(4);
			p.setNombre("Arroz");
			p.setPrecio(80.0);
			p.setStock(54);
			return p;
		};

		Producto p = new Producto();
		Producto newProd = prod.apply(p);
		addProducto(newProd);
		getProductos();

	}

	// Metodo estatico para Imprimir la lista de productos
	public static void getProductos() {
		System.out.println("Lista de productos:");
		productos.forEach(System.out::println);
		System.out.println();
	}

	// Metodo estatico para buscar un producto por su código
	public static Producto getProducto(int id) {
		return productos.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
	}

	// Metodo estatico para eliminar un producto por su código
	public static void deleteProducto(int code) {
		// Se borra un producto por medio de lambda predicate
		Predicate<Producto> predicate = producto -> producto.getId() == code;
		productos.removeIf(predicate);
	}

	// Metodo estatico para agregar un nuevo producto
	public static void addProducto(Producto producto) {

		productos.add(producto);
	}
}
