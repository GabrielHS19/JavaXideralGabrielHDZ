package com.singleton;

public class Usuario {
    
    //Se definen las variables de referencias, en este caso nombre y la conexion que se le asigna al usuario

     private String nombre;
     private ConexionDB conexion;

     // se crea el metodo constructor

    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    // se crea el metodo que le asigna la conexion al usuario
    

    public void setCon(ConexionDB con) {
        this.conexion = con;
        System.out.println("El usuario: " + nombre + " se conectó de manera exitosa a la base de datos" );
        
    }
    
    
    

}
