
package com.inyeccion.constructor;


public class Retiro implements Tramite{
    
    //Se definen las variables de referencia que se usarán
    // implementando la encapsulacion
    
    private int noDeCuenta;
    private double monto;
    
    //se declaran los metodos setter de las variables

    public void setNoDeCuenta(int noDeCuenta) {
        this.noDeCuenta = noDeCuenta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
     //se declara el metodo heredado de la interface y se sobreescribe

    @Override
    public void realizarOperacion() {
        System.out.println(" Ha realizado el tramite de retiro de $ " + monto + " al numero de cuenta " + noDeCuenta);
    }

    
    
}
