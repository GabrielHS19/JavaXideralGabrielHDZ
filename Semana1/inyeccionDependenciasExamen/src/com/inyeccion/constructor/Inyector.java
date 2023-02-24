package com.inyeccion.constructor;

public class Inyector {
    
    //Se crean los objetos estaticos ya que los metodos estaticos deben de usar
    // variables estaticas
    
    static Tramite dep = new Deposito();
    static Tramite ret = new Retiro();
    static Tramite pagS = new pagarServicio();
    
    //definimos el metodo estatico que vamos a usar y que retornará un usuario, en este 
    // pedimos todos los parametros que necesitamos
    

    static Usuario getUsuario(String name, double monto, int cuenta, String tipo) {
        
        //definimos la variables de referencia

        Usuario u;
        
        //Se define un switch para conocer el tipo de tramite que se requiere

        switch (tipo) {
            case "deposito":
                //Se hace cast de la variable tipo tramite a la clase necesaria para poder
                //hacer set del monto y el numero de cuenta
                ((Deposito) dep).setNoDeCuenta(cuenta);
                ((Deposito) dep).setMonto(monto);
                //se crea el usuario con los datos adiministrados
                u = new Usuario(name, dep);
                break;
            case "retiro":
                ((Retiro)ret).setNoDeCuenta(cuenta);
                ((Retiro)ret).setMonto(monto);
                u = new Usuario(name, ret);
                break;
            default:
                ((pagarServicio)pagS).setNoDeCuenta(cuenta);
                ((pagarServicio)pagS).setMonto(monto);
                u = new Usuario(name, pagS);
        }
        //se devuelve el usuario generado
        return u;

    }

}
