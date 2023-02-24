
package com.inyeccion.constructor;


public class Usuario {

private String nombre;
private Tramite tramite;

    public Usuario(String nombre, Tramite tramite) {
        this.nombre = nombre;
        this.tramite = tramite;
    }



public void realizarTramite(){
    System.out.println("************************************");
    System.out.print("El usuario: " +  nombre);
    tramite.realizarOperacion();
    System.out.println("************************************");
}

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    


}
