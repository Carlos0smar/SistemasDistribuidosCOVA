package org.example.Servidores;
import org.example.Ruat;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


public class RuatServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        LocateRegistry.createRegistry(1099);
        Naming.bind("RUAT", new Ruat());
    }
}
