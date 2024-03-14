package org.example;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)throws RemoteException, AlreadyBoundException, MalformedURLException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        IOperation operation;
        operation = (IOperation) Naming.lookup("rmi://localhost/Factorial"); // instanciar un objeto remoto
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        System.out.println("The factorial of " + number + " is: ");
        System.out.println (operation.calculate(number));
    }
}
