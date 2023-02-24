package com.clase.abstracta;

public class arcticMonkeys extends bandaMusical {
    
    //se declara una variable que es constante ya que nunca va a cambiar
    private final String name="Arctic Monkeys";
    
    //se sobreescriben los metodos heredados de la clase padre
    @Override
    public void playSong() {
        System.out.println("Reproduciendo...");
        System.out.println("I thought i saw you in the battleship but...");
    }

    @Override
    public String getName() {
        return name;
    }

}
