/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */

    private static final String DIRECTORIO = "D:\\UNIVERSIDAD\\7mo_Semestre\\SIS258_SistemasDistribuidos\\Assignments\\test_secondAssingment";

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int port = 5002;
        ServerSocket server;

        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio la calculadora con éxito");
            Socket client;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            System.out.println("Cliente se conecto");


            String recibido=fromClient.readLine();
            if (recibido.equals("enviar")) {
                recibirArchivo(client.getInputStream());
            } else if (recibido.equals("solicitar")) {
                enviarArchivo(toClient, fromClient, client);
            }

//                toClient.println(resul);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }


    private static void recibirArchivo(InputStream in) throws IOException {
        // Leer nombre del archivo y su tamaño
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String nombreArchivo = reader.readLine();
//        long tamanoArchivo = Long.parseLong(in.readLine());

        // Crear stream de salida para escribir el archivo
        FileOutputStream fos = new FileOutputStream(DIRECTORIO + File.separator + nombreArchivo);

        // Leer los bytes del archivo y escribirlos en el directorio remoto
        byte[] buffer = new byte[4096];

        in.read(buffer, 0, buffer.length);
        fos.write(buffer, 0, buffer.length);


        // Cerrar stream de salida
        fos.close();
        System.out.println("Archivo recibido correctamente: " + nombreArchivo);
    }



    private static void enviarArchivo(PrintWriter out, BufferedReader fromClient, Socket sc) throws IOException {
        // Solicitar al cliente el nombre del archivo que desea recibir
        out.println("Por favor, ingrese el nombre del archivo que desea recibir:");

        String nombreArchivo = fromClient.readLine();

        // Enviar el nombre del archivo al cliente
        out.println(nombreArchivo);

        // Crear stream de entrada para leer el archivo
        FileInputStream fis = new FileInputStream(DIRECTORIO + File.separator + nombreArchivo);

        // Enviar el archivo al cliente
        byte[] buffer = new byte[4096];
        fis.read(buffer, 0, buffer.length);
        OutputStream os = sc.getOutputStream();
        os.write(buffer, 0, buffer.length);



        // Cerrar streams
        fis.close();
        System.out.println("Archivo enviado correctamente: " + nombreArchivo);
    }
}
