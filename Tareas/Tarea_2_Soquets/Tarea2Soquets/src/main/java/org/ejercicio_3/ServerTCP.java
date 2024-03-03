/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.HashMap;
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
                String resul = checkAvailability(recibido) ? "The page is available" : "The page is not available";
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resul);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static boolean checkAvailability(String url) {
        try {
            URL sitioWeb = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) sitioWeb.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            return (responseCode == HttpURLConnection.HTTP_OK);
        } catch (IOException e) {
            return false;
        }
    }
}
