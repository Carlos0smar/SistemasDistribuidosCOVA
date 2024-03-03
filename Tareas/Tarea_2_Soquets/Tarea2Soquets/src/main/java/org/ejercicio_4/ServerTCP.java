/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */

    private static final String DIRECTORIO = "D:\\Guitar Lessons";

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
                String resul = searchFile(recibido) ? "The file exist" : "The file doesn't exist";
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resul);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static boolean searchFile(String nombreArchivo) {
        File directorio = new File(DIRECTORIO);
        if (!directorio.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return false;
        }

        File[] archivos = directorio.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().equals(nombreArchivo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
