package com.inyeccion.setter;

public class Inyector {

    //Se crean los objetos estaticos ya que los metodos estaticos deben de usar
    // variables estaticas
    static Tramite dep = new Deposito();
    static Tramite ret = new Retiro();
    static Tramite pagS = new pagarServicio();

    //definimos los metodos estaticos que se encagarán de proporcionales el 
    // tramite al usuario que llega como parametro, asi como tambien
    //llegan como parametros algunos datos necesarios del tramite los cuales
    //son el monto del tramite y el numero de cuenta
    
    static void inyectarDeposito(Usuario u, double monto, int cuenta) {
        //Se hace cast de la variable tipo tramite a la clase necesaria para poder
        //hacer set del monto y el numero de cuenta 
        
        ((Deposito) dep).setNoDeCuenta(cuenta);
        ((Deposito) dep).setMonto(monto);
        
        //se le asigna el objeto tramite al usuario
        u.setTramite(dep);
    }

    static void inyectarRetiro(Usuario u, double monto, int cuenta) {
        ((Retiro) ret).setNoDeCuenta(cuenta);
        ((Retiro) ret).setMonto(monto);
        u.setTramite(ret);
    }

    static void inyectarPagarServicio(Usuario u, double monto, int cuenta) {
        ((pagarServicio) pagS).setNoDeCuenta(cuenta);
        ((pagarServicio) pagS).setMonto(monto);
        u.setTramite(pagS);
    }

}
