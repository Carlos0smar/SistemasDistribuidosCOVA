package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String recibido=fromClient.readLine();
            System.out.println(recibido);
            System.out.println("Introducir el mensaje a enviar al cliente:");
            String cadena=sc.nextLine();
            toClient = new PrintStream(client.getOutputStream());
            toClient.println(cadena);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
