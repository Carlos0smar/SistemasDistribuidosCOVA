package org.example.servidores;

import org.example.Cotes;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServidorCotes {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Naming.bind("Cotes", new Cotes());
    }
}
