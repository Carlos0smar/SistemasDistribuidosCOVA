package org.example.Clientes;
import org.example.Deuda;
import org.example.Impuesto;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class UsurarioClienteTCP {

    static String[] deudas;
    static String ci;


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int port = 5002;
        try {
            Socket client = new Socket("localhost", port);

            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            menu();
            String option = sc.next();

            toServer.println(options(option));
            protocolManagment(fromServer.readLine());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String options(String option){
        Scanner sn = new Scanner(System.in);
        switch (option){
            case "1":
                System.out.println("Introduce ci:");
                ci = sn.next();
                return " deuda:"+ci;
            case "2":
                System.out.println("Selecciona la deuda a pagar");
//                int i = 1;
//                for(String deuda: deudas){
//                    System.out.println(i + deuda);
//                }
                int deudaAPagar = sn.nextInt();
                String deadaPorPagar = deudas[deudaAPagar-1];
                return ci +"," + deadaPorPagar;
            default:
                return "invalido";
        }
    }

    static void menu(){
        System.out.println("1. Ver Deudas");
        System.out.println("2. Pagar Deudas");

    }


    static void protocolManagment(String returnedValue){
        String[] protocolo = returnedValue.split(":");

        if(protocolo[0].equals("deudas")){
            deudaManagment(protocolo[1]);
        }

        if(protocolo[1].equals("transaccion")){
            transaccionManagment(protocolo[1]);
        }
    }

    static void deudaManagment(String deudaCadena){
        System.out.println("Deudas a pagar");
        deudas = deudaCadena.split(";");
        int i = 1;
        for(String deuda: deudas){
            System.out.println(i + deuda);
        }
    }


    static void transaccionManagment(String pago){
        if(pago.equals("true")){
            System.out.println("Se pagó con exito");
        }

        if(pago.equals("false")){
            System.out.println("No se pagó con exito");
        }
    }
}
