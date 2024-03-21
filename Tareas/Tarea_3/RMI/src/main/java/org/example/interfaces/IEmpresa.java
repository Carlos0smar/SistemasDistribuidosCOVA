package org.example.interfaces;

import org.example.Factura;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEmpresa extends Remote {
    public Factura[] pendiente(int idCliente)throws RemoteException;
    public String pagar(Factura[] facturas) throws RemoteException;
}
