package org.example.Ejercicio_2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMultiHilo {
    public static void main(String[] args) throws IOException
    {
        // Escuchandoen el puerto 5056
        ServerSocket ss = new ServerSocket(5056);

        //ciclo al infinito
        while (true)
        {
            Socket s = null;

            try
            {
                // Coneccion del cliente
                s = ss.accept();

                System.out.println("un nuevo cliente se ha conectado : " + s);
                PrintWriter dos = new PrintWriter(s.getOutputStream(), true);
                BufferedReader dis = new BufferedReader(new InputStreamReader(s.getInputStream()));
                // obtener su entrada y salida de stream
                System.out.println("Aginar unnuevo hilopara este cliente ");

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);

                // Invoking the start() method
                t.start();

            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}
