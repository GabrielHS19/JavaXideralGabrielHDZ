
package com.interfaces;

public class twentyOnePilots implements bandaMusical{
   
    //se declara una variable que es constante ya que nunca va a cambiar
    private final String name="Twenty One Pilots";
    
    //se sobreescriben los metodos heredados de la clase padre
    @Override
    public void playSong(){
        System.out.println("Reproduciendo...");
        System.out.println("I wanna fall inside your ghost and fill...");
    }

    @Override
    public String getName() {
        return name;
    }
     
}
