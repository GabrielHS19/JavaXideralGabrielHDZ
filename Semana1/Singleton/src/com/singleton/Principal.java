
package com.singleton;


public class Principal {
    public static void main(String[] args){
        
        //se crean 3 objetos de tipo usuario y cada uno se encarga de obtener una conexion
        
        Usuario usuario1 = new Usuario("José");
        usuario1.setCon(ConexionDB.getInstancia());
        
        Usuario usuario2 = new Usuario("Mario");
        usuario2.setCon(ConexionDB.getInstancia());
        
        Usuario usuario3 = new Usuario("Alfredo");
        usuario3.setCon(ConexionDB.getInstancia());
        
        //se imprimen las veces que se creó un objeto de tipo ConexionDB
        
        
        System.out.println("La cantidad de veces que se creó una conexion fue : " + ConexionDB.getContador());
       
        
    }
}
