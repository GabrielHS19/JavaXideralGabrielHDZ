package com.luv2code.web.jdbc;

public class Cuenta{
	
	//Se declaran las variables de cuenta

	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private Double balance;
	
	//se crean dos metodos constructores

	public Cuenta(String nombre, String apellido, String email,Double balance) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.balance = balance;
	}

	public Cuenta(int id, String nombre, String apellido, String email,Double balance) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.balance = balance;
	}
	
	//Se declaran setters y getters de las variables

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	

		
}
