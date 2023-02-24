
package com.interfaces;


public class fosterThePeople implements bandaMusical{
    
    //se declara una variable que es constante ya que nunca va a cambiar
    private final String name="Foster the people";
    
    //se sobreescriben los metodos heredados de la clase padre
    @Override
    public void playSong(){
        System.out.println("Reproduciendo...");
        System.out.println("I'll hold your hand when you are feeling mad at me...");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
