package org.example.ejercicio1;

public class Cuenta {
    double saldo;

    public Cuenta() {
        this.saldo = 0;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositarDinero(double dinero){
        saldo += dinero;
    }

    public void reitrarDinero(double dinero){
        if(dinero > saldo){
            System.out.println("No tiene el suficiente saldo para retirar el monto: " + dinero);
            return;
        }
        saldo -= dinero;
    }

    public void mostrarSaldo(){
        System.out.println("El saldo es: " + saldo);
    }


}
