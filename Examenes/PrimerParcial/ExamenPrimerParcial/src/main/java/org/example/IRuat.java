package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRuat extends Remote{
    Deuda[] buscar(String ci) throws RemoteException;
    Boolean pagar(Deuda deuda) throws RemoteException;

}
