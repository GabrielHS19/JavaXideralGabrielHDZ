
package com.interfaces;


public class theStrokes implements bandaMusical{
    
    //se declara una variable que es constante ya que nunca va a cambiar
    private final String name="The Strokes";
    
    //se sobreescriben los metodos heredados de la clase padre
    @Override
    public void playSong(){
        System.out.println("Reproduciendo...");
        System.out.println("Was an honest man, asked me for...");
    }

    @Override
    public String getName() {
        return name;
    }
    
}
