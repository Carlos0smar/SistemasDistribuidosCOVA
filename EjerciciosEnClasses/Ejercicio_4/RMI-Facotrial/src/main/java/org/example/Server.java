package org.example;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args)throws RemoteException, AlreadyBoundException, MalformedURLException {
        Factorial factorial=new Factorial();
        LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
        Naming.bind("Factorial",factorial);
    }
}
