package org.example;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStringOperator extends Remote {
    boolean introducirValor(String cadena) throws RemoteException, MalformedURLException, NotBoundException;
    String invertir()throws RemoteException, MalformedURLException, NotBoundException;
    String aumentarSpacios(int cantidadSpacios) throws RemoteException, MalformedURLException, NotBoundException;
    String aumentar(String cadena)throws RemoteException, MalformedURLException, NotBoundException;

}
