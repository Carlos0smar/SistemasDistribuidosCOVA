package org.example.interfaces;

import org.example.Factura;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBanco extends Remote {
    public Factura[] calcular(int idCliente) throws RemoteException, MalformedURLException, NotBoundException;
    public String pagar(Factura[] facturas) throws RemoteException, MalformedURLException, NotBoundException;
}
