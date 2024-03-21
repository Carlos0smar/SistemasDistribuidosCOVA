package org.example.clientes;

import org.example.Factura;
import org.example.interfaces.IBanco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClienteBanco {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        IBanco banco = (IBanco) Naming.lookup("rmi://localhost/Banco"); // instanciar un objeto remoto

        System.out.println("Cliente Banco: 1");

        Factura[] facturas1 = banco.calcular(1);
        for(Factura factura: facturas1){
            System.out.println(factura.toString());
        }

        System.out.println(banco.pagar(facturas1));

        System.out.println("Cliente Banco: 2");
        Factura[] facturas2 = banco.calcular(2);

        for(Factura factura: facturas2){
            if (factura == null) break;
            System.out.println(factura.toString());
        }
        System.out.println(banco.pagar(facturas2));
    }
}