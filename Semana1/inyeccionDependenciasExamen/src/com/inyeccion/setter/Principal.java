package com.inyeccion.setter;

import java.util.Scanner;

public class Principal {
    

    public static void main(String[] args) {
        
        // se delcaran todas las variables de referencia que se usarán 
        Scanner sc = new Scanner(System.in);
        String name;
        int cuenta, next;
        double monto;
        
        //se crea el usuario que se ocupará
        Usuario usuario = new Usuario();
        
        //se piden los datos necesarios para el funcionamiento del programa

        System.out.println("Bienvenido al Banco de las Americas ");
        System.out.println("Ingrese su nombre: ");
        usuario.setNombre(name = sc.nextLine());
        System.out.println("Ingrese su numero de cuenta: ");
        cuenta = sc.nextInt();
        
        //se inicia un ciclo para que el programa acabe cuando el usuario lo decida

        do {
            System.out.println("Elige el tramite que quieres realizar: ");
            System.out.println("1. Deposito");
            System.out.println("2. Retiro");
            System.out.println("3. Pagar un servicio");

            int op = sc.nextInt();
            switch (op) {

                case 1:
                    
                    System.out.println("Ingrese el monto total a depositar: ");
                    monto = sc.nextDouble();
                    
                    // Se invoca el metodo estatico para asignarle un objeto tramite
                    // al usuario ademas de otros datos
                    Inyector.inyectarDeposito(usuario, monto,cuenta);
                    //se ejecuta el metodo para realizar el tramite
                    usuario.realizarTramite();
                    break;
                case 2:
                    System.out.println("Ingrese el monto total a retirar: ");
                    monto = sc.nextDouble();
                    Inyector.inyectarRetiro(usuario,monto, cuenta);
                    usuario.realizarTramite();
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a pagar del setvicio: ");
                    monto = sc.nextDouble();
                    Inyector.inyectarPagarServicio(usuario,monto, cuenta);
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
