package com.clase.abstracta;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        //se declaran las variables referenciasles que se ocuparan mas adelante

        Scanner sc = new Scanner(System.in);
        int op;
        bandaMusical banda;
        
        //se comienza a declarar los mensajes informativos para ocupar el programa

        System.out.println("Bienvenido a Spotify");
        System.out.println("Elige algunas de las siguientes opciones");
        System.out.println("1. Reproducir aleatoriamente una cancion");
        System.out.println("2. Elige alguna banda y reproduce alguno de sus exitos");
        op = sc.nextInt();
        
        //se define un switch para escoger la opcion que se desea
        switch(op){
            case 1:
                //se obtiene una banda de forma random con la aplicacion de un metodo
                banda = getBanda();
                // se obtiene el nombre de la banda mediante un metodo get y se imprime el reaultado
                System.out.println(banda.getName());
                //se ejecuta el metodo principal
		banda.playSong();
                break;
            case 2:
                //se ejecuta una parte del codigo en donde se elige una sola opcion ya no de manera random
                // si no de manera concreta
                System.out.println("Escoge la banda que deseas para reproducir algunos de sus exitos");
                System.out.println("1. Twenty One Pilots");
                System.out.println("2. The Strokes");
                System.out.println("3. Arctic Monkeys");
                System.out.println("4. Foster The People");
                op = sc.nextInt();
                if(op==1){
                    banda = new twentyOnePilots();
                    System.out.println(banda.getName());
                    banda.playSong();
                }else if(op==2){
                    banda = new theStrokes();
                    System.out.println(banda.getName());
                    banda.playSong();
                }else if(op==3){
                    banda = new arcticMonkeys();
                    System.out.println(banda.getName());
                    banda.playSong();
                }else{
                    banda = new fosterThePeople();
                    System.out.println(banda.getName());
                    banda.playSong();
                }
                break;
                
        }
    }
    
    //metodo que arroja un objeto de banda de manera random
    private static bandaMusical getBanda() {
		bandaMusical[] bandas = {new fosterThePeople(),new theStrokes(),new arcticMonkeys(),new twentyOnePilots()};
		int entero = new Random().nextInt(bandas.length);
		return bandas[entero];
	}

}
