package org.example.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerBCP {
    static PrintStream toClient;
    static BufferedReader fromClient;

    public static void main(String[] args) {

        int port = 5002;
        ServerSocket server;
        try {
            while (true) {
                server = new ServerSocket(port);

                Socket client;
                client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
                fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                toClient = new PrintStream(client.getOutputStream());
                System.out.println("Cliente se conecto");

                // TODO puede haber problema en la recepciond e datos
                String recibido = fromClient.readLine();
                toClient.println(procesarProtocolo(recibido));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static String procesarProtocolo(String solicitud) {
        String[] comandos = solicitud.split(":");

        if(comandos[0].equals("Buscar")){
            return buscarCuentas(comandos[1]);
        }

        if(comandos[0].equals("Congelar")){
            return retenerMonto(comandos[1]);
        }

        return "no:encontrado";
    }

    public static String buscarCuentas(String solicitud) {
        String cuentas = "";

        String[] datos = solicitud.split("-");

        if (datos[0].equals("7687682") && datos[1].equals("Juan") && datos[2].equals("Segovia")) {
            cuentas = "657654-2000";
            return cuentas;
        }
        if (datos[0].equals("455787") && datos[1].equals("Ricardo") && datos[2].equals("Centellas")) {
            cuentas = "657255-5890";
            return cuentas;
        }

        return "no:encontrado";
    }

    public static String retenerMonto(String solicitud) {
        String[] datos = solicitud.split("-");

        if (datos[0].equals("657654") && Integer.parseInt(datos[1])<=2000) {
            return "Si-657654";
        }

        if (datos[0].equals("657255") && Integer.parseInt(datos[1]) <= 5890) {
            return "Si-657255";
        }

        return "no-noencontrado";
    }
}
