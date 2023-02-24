package com.singleton;

public class ConexionDB {
    
    //Se crean las variables estaticas que solo le pertecen a la clase de ConexionDB

    static private ConexionDB con;
    private static int contador;
    
    //En el constructor se sumará 1 cada vez que el constructor sea invocado, es decir
    // cada que se cree un objeto

    private ConexionDB() {
        contador++;
    }
    
    //el metodo getContador devuelve el contador de la clase

    public static int getContador() {
        return contador;
    }
    
    //se define el patron singleton en donde unicamente se crea un metodo de la clase conexionDB
    // si es que previamente no existe, si este ya existe entonces el metodo solo lo devuelve

    public static ConexionDB getInstancia() {
        if (con == null) {
            con = new ConexionDB();
        }
        return con;
    }

}
