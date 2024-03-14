package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperation extends Remote {
    Integer calculate(int number) throws RemoteException;
}
