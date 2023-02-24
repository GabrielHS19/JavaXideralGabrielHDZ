package com.inyeccion.constructor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        // se delcaran todas las variables de referencia que se usarán 

        Scanner sc = new Scanner(System.in);
        String name;
        int cuenta, next, op;
        double monto;
        Usuario usuario;
        
        //Se invoca a un metodo que crea el usuario con sus respectivos datos usando 
        //el constructor 

        usuario = Inyector.getUsuario("Pedro", 433.0, 4343, "deposito");
        
        // se invoca el metodo que realiza el tramite
        usuario.realizarTramite();
        System.out.println();
        
        //Se piden los datos necesarios para el funcionamiento del programa

        System.out.println("Bienvenido al Banco de las Americas ");
        System.out.println("Ingrese su nombre: ");
        name = sc.nextLine();
        System.out.println("Ingrese su numero de cuenta: ");
        cuenta = sc.nextInt();

        do {
            System.out.println("Elige el tramite que quieres realizar: ");
            System.out.println("1. Deposito");
            System.out.println("2. Retiro");
            System.out.println("3. Pagar un servicio");

            op = sc.nextInt();
            switch (op) {
                
               
                case 1:
                    
                    System.out.println("Ingrese el monto total a depositar: ");
                    monto = sc.nextDouble();
                    //se crea el usuario con los datos proporcionados en el constructor
                    usuario = Inyector.getUsuario(name, monto, cuenta, "deposito");
                    usuario.realizarTramite();

                    break;
                case 2:
                    System.out.println("Ingrese el monto total a retirar: ");
                    monto = sc.nextDouble();
                    usuario = Inyector.getUsuario(name, monto, cuenta, "retiro");
                    usuario.realizarTramite();
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a pagar del setvicio: ");
                    monto = sc.nextDouble();
                    usuario = Inyector.getUsuario(name, monto, cuenta, "servicio");
                    usuario.realizarTramite();
                    break;

            }
            System.out.println("Deseas hacer otro tramite?");
            System.out.println("1. Si");
            System.out.println("2. No");
            next = sc.nextInt();
        } while (next == 1);

    }

}
