package org.example.Ejercicio_3;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Operacion extends UnicastRemoteObject implements IOperacion {
    int a, b;
    public Operacion() throws RemoteException {
        super();
    }

    @Override
    public void anotar(int a, int b) throws RemoteException, MalformedURLException, NotBoundException {
        this.a = a;
        this.b = b;
    }

    @Override
    public int suma() throws RemoteException, MalformedURLException, NotBoundException {
        return a+b;
    }

    @Override
    public int resta() throws RemoteException, MalformedURLException, NotBoundException {
        return a-b;
    }
}
