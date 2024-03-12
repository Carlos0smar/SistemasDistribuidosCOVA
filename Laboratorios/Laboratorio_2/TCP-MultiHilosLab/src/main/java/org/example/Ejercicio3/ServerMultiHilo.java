package org.example.Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMultiHilo {

    private static final List<Task> Tasks = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        // Escuchandoen el puerto 5056
        ServerSocket ss = new ServerSocket(5056);
        Operations operations = new Operations(Tasks);
        //ciclo al infinito
        while (true) {
            Socket s = null;
            try {
                // Coneccion del cliente
                s = ss.accept();
                System.out.println("New client connected : " + s);

                // obtener su entrada y salida de stream
                DataInputStream dis = new DataInputStream(s.getInputStream());
                ObjectOutputStream dos = new ObjectOutputStream(s.getOutputStream());

                System.out.println("Assigning new thread for this client ");
                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos, operations);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }
        }
    }

}