
package com.polimorfismo;


public class bandaMusical {
    
    //se declara la variable de referencia
    private String name;
    
    //se declaran los metodos que heredarán los hijos 
    public void playSong(){
        System.out.println("No reproduce ninguna cancion");
    }
    
    public String getName(){
        return name;
    }
}
