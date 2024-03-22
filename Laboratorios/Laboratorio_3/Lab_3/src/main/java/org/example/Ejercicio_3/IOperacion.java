package org.example.Ejercicio_3;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperacion extends Remote {
    public void anotar(int a, int b) throws RemoteException, MalformedURLException, NotBoundException;
    public int suma() throws RemoteException, MalformedURLException, NotBoundException;
    public int resta() throws RemoteException, MalformedURLException, NotBoundException;
}
