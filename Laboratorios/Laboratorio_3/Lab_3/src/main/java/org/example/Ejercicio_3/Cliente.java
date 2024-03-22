package org.example.Ejercicio_3;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Scanner sc = new Scanner(System.in);
        IOperacion operacion = (IOperacion) Naming.lookup("rmi://localhost/Operacion"); // instanciar un objeto remoto
        while (true){

            menu();
            int opcion = sc.nextInt();
            setOpcion(opcion, operacion);
        }

    }

    static void setOpcion(int opcion, IOperacion operacion) throws MalformedURLException, NotBoundException, RemoteException {
        Scanner sc = new Scanner(System.in);
        switch (opcion){
            case 1:
                System.out.println("Ingrese el primer numero");
                int a = sc.nextInt();
                System.out.println("Ingrese el segundo numero");
                int b = sc.nextInt();
                operacion.anotar(a, b);
                break;
            case 2:
                System.out.println("La suma es: " + operacion.suma());
                break;
            case 3:
                System.out.println("La resta es: "+ operacion.resta());
                break;
            case 4:
                System.exit(0);
        }

    }
    static void menu(){
        System.out.println("1. Introductir numeros");
        System.out.println("2. Suma");
        System.out.println("3. Resta");
        System.out.println("4. Salir");
    }
}