package org.example.Ejercicio1;

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

    public static void broadcast(String message, Socket socket) throws IOException {
        for (ClientHandler client : clients) {
            if(client.s.getPort() != socket.getPort()){
                client.dos.writeUTF(message);
            }
        }
    }
}