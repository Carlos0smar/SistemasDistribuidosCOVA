/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio la calculadora con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            while (true){
                String recibido=fromClient.readLine();
                int resul = makeOperation(recibido);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resul);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static ArrayList<Integer> getValues(String cadena){
        String[] values = cadena.split(operator(cadena));
        ArrayList<Integer> integerValues = makeInteger(values);
        return integerValues;
    }

    public static String operator(String cadena){
        if(cadena.contains("+")){
            return "\\+";
        }

        if(cadena.contains("-")){
            return "-";
        }

        if(cadena.contains("*")){
            return "\\*";
        }

        if(cadena.contains("/")){
            return "/";
        }

        return "";
    }

    public static ArrayList<Integer> makeInteger(String[] values){
        ArrayList<Integer> integerValues = new ArrayList<>();
        for(String i : values){
            integerValues.add(Integer.parseInt(i));
        }
        return integerValues;
    }


    public static int makeOperation(String cadena){
        ArrayList<Integer> integerValues = getValues(cadena);
        int resul;
        switch (operator(cadena)){
            case "\\+":
                return integerValues.get(0) + integerValues.get(1);
            case "-":
                return integerValues.get(0) - integerValues.get(1);
            case "/":
                return integerValues.get(0) / integerValues.get(1);
            case "\\*":
                return integerValues.get(0) * integerValues.get(1);
        }
        return 0;
    }
}
