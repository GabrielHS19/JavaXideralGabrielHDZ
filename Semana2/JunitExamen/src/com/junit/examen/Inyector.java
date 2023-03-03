package com.junit.examen;

public class Inyector {

    //Se crean los objetos estaticos ya que los metodos estaticos deben de usar
    // variables estaticas
    static Electrodomestico lav = new Lavadora();
    static Electrodomestico lic = new Licuadora();
    static Electrodomestico plan = new Plancha();

    //definimos los metodos estaticos que se encagarán de proporcionales el 
    // tramite al usuario que llega como parametro, asi como tambien
    //llegan como parametros algunos datos necesarios del tramite los cuales
    //son el precio del electrodomestico y la compra a realizar
    
    static void inyectarLavadora(Compra comp, double precio) {
        //Se hace cast de la variable tipo compra a la clase necesaria para poder
        //hacer set del precio 
        ((Lavadora) lav).setPrecio(precio);
        //se le asigna el objeto lavadora a la compra
        comp.setElectrodomestico(lav);
    }

    static void inyectarLicuadora(Compra comp, double precio) {
    	((Licuadora) lic).setPrecio(precio);
        //se le asigna el objeto licuadora a la compra
        comp.setElectrodomestico(lic);
    }

    static void inyectarPlancha(Compra comp, double precio) {
    	((Plancha) plan).setPrecio(precio);
        //se le asigna el plancha  a la compra
        comp.setElectrodomestico(plan);
    }

}
