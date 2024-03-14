package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Factorial extends UnicastRemoteObject implements IOperation {
    public Factorial() throws RemoteException {
        super();
    }

    @Override
    public Integer calculate(int number) throws RemoteException {
        for(int i = number - 1; i > 0; i--){
            number *= i;
        }
        return number;
    }
}
