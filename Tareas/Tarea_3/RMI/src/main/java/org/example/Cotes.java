package org.example;

import org.example.interfaces.IEmpresa;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cotes extends UnicastRemoteObject implements IEmpresa {
    public Cotes() throws RemoteException {
        super();
    }
    @Override
    public Factura[] pendiente(int idCliente) throws RemoteException {
        Factura[] facturaCliete = new Factura[3];

        Empresa empresa = new Empresa("Cotes", 234123456L);
        switch (idCliente){
            case 1:
                facturaCliete[0] = new Factura(empresa, 114, Mes.DICIEMBRE, 2021, 170);
                facturaCliete[1] = new Factura(empresa, 321, Mes.ENERO, 2022, 100);
                facturaCliete[2] = new Factura(empresa, 22454, Mes.FEBRERO, 2022, 150);
                break;
            case 2:
                facturaCliete[0] = new Factura(empresa, 225, Mes.ENERO, 2022, 150);
                facturaCliete[1] = new Factura(empresa, 1125, Mes.FEBRERO, 2022, 200);
                break;
        }
        return facturaCliete;
    }

    @Override
    public String pagar(Factura[] facturas) throws RemoteException {
        StringBuilder facturasPagadas = new StringBuilder();
        if (facturas != null){
            for (Factura factura: facturas){
                facturasPagadas.append(factura.getIdFactura()).append(" ");
            }
            return "Facturas Cotes pagadas: " + facturasPagadas;
        }
        return "";
    }
}