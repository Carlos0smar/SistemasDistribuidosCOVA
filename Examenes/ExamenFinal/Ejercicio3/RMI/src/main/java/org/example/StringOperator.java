package org.example;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StringOperator extends UnicastRemoteObject implements IStringOperator{
    String globalCadena;
    protected StringOperator() throws RemoteException {
    }

    @Override
    public boolean introducirValor(String cadena) throws RemoteException, MalformedURLException, NotBoundException {
        globalCadena = cadena;
        return true;
    }

    @Override
    public String invertir() throws RemoteException, MalformedURLException, NotBoundException {
        String newCadena = "";
        for (int i = globalCadena.length() - 1; i >= 0; i--) {
            newCadena += globalCadena.charAt(i);
        }

        globalCadena = newCadena;
        return globalCadena;
    }

    @Override
    public String aumentarSpacios(int cantidadSpacios) throws RemoteException, MalformedURLException, NotBoundException {
        ArrayList<String> spaces = new ArrayList<String>();
        char[] letras = globalCadena.toCharArray();
        String nuevaPalabra = "";
        for(int index = 0; index< globalCadena.length(); index++){
            nuevaPalabra += letras[index];
            nuevaPalabra += " ";
        }
        globalCadena = nuevaPalabra;
        return globalCadena;
    }

    @Override
    public String aumentar(String cadena) throws RemoteException, MalformedURLException, NotBoundException {
        globalCadena += cadena ;
        return globalCadena;
    }
}
