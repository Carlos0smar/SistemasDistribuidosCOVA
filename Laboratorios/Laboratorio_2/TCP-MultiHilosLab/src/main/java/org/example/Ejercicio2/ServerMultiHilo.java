package org.example.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMultiHilo {

    private static final List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        ServerSocket ss = new ServerSocket(5056);

        //ciclo al infinito
        while (true) {
            Socket s = null;
            try {
                // Coneccion del cliente
                s = ss.accept();
                System.out.println("New client connected : " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client ");
                // create a new thread object
                ClientHandler t = new ClientHandler(s, dis, dos);
                clients.add(t);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }
    public static void score() throws IOException {
        System.out.println("/////////////////////////");
        System.out.println("SCORES");
        System.out.println();
        for (ClientHandler client : clients) {
            System.out.println("cliente: " + client.s.getPort());
            System.out.println("Puntaje: " + client.score);
        }
        System.out.println("/////////////////////////");
    }
}