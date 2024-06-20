package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class StringOperatorClient {
    static Scanner sn = new Scanner(System.in);
    static IStringOperator stringOperator;
    static String resultado;
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        stringOperator = (IStringOperator) Naming.lookup("rmi://localhost/StringOperator"); // instanciar un objeto remoto

        while(true){
            menu();
            int action = sn.nextInt();
            operation(action);
            System.out.println("Estado de la palabra actual");
            System.out.println(resultado);
        }

    }

    private static void operation(int action) throws MalformedURLException, NotBoundException, RemoteException {
        switch (action){
            case 1 :
                System.out.println("Introducir la palabra");
                String palabra = sn.next();
                stringOperator.introducirValor(palabra);
                break;
            case 2:
                resultado = stringOperator.invertir();
                break;
            case 3:
                System.out.println("Introducir cantidad de espacio a aumentar");
                int cantidad = sn.nextInt();
                resultado = stringOperator.aumentarSpacios(cantidad);
                break;
            case 4:
                System.out.println("Introducir palabra a aumentar");
                String nuevaPalabra = sn.next();
                resultado = stringOperator.aumentar(nuevaPalabra);
                break;
        }
    }


    static void menu(){
        System.out.println("1.Introducir");
        System.out.println("2.invertir");
        System.out.println("3.aumetar espcaios");
        System.out.println("4.aumentar");

    }
}
