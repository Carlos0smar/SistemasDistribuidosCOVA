package org.example;

import org.example.interfaces.IEmpresa;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cessa extends UnicastRemoteObject implements IEmpresa {
    public Cessa() throws RemoteException {
        super();
    }
    @Override
    public Factura[] pendiente(int idCliente) throws RemoteException {
        Factura[] facturaCliete = new Factura[2];
        Empresa empresa = new Empresa("Cessa", 343123456L);
        switch (idCliente){
            case 1:
                facturaCliete[0] = new Factura(empresa, 154, Mes.DICIEMBRE, 2021, 150);
                facturaCliete[1] = new Factura(empresa, 326, Mes.ENERO, 2021, 701);
                break;
            case 2:
                facturaCliete[0] = new Factura(empresa, 324, Mes.ENERO, 2021, 610);
                facturaCliete[1] = new Factura(empresa, 457, Mes.FEBRERO, 2021, 801);
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
            return "Facturas Cessa pagadas: " + facturasPagadas;
        }
        return "";
    }

}
