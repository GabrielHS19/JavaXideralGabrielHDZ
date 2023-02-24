
package com.inyeccion.setter;


public class pagarServicio implements Tramite{
    
    private int noDeCuenta;
    private double monto;

    public void setNoDeCuenta(int noDeCuenta) {
        this.noDeCuenta = noDeCuenta;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    

    @Override
    public void realizarOperacion() {
        System.out.println(" Ha realizado el tramite de pago de servicio de $ " + monto + " al numero de cuenta " + noDeCuenta);
    }

   
    
}
