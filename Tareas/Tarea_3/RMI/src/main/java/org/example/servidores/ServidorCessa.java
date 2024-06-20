package org.example.servidores;

import org.example.Cessa;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServidorCessa {
    public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
        Naming.bind("Cessa", new Cessa());
    }
}
