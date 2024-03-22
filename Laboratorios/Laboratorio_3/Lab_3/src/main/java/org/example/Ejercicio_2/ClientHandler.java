package org.example.Ejercicio_2;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {

    final BufferedReader dis;
    final PrintWriter dos;
    String nombreCliente;
    final Socket s;
    private final String[] palabras = {"HOLA", "MUNDO", "PROGRAMACION", "SOCKET", "JAVA"};

    // Constructor
    public ClientHandler(Socket s, BufferedReader dis, PrintWriter dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;

        while (true) {
            try {

                dos.println("Bienvenido al Juego del Ahorcado!");
                dos.println("Por favor, ingresa tu nombre:");
                nombreCliente = dis.readLine();
                dos.println("Bienvenido, " + nombreCliente.toUpperCase() + "! Comencemos el juego.");

                String palabraSeleccionada = palabras[(int) (Math.random() * palabras.length)];
                char[] palabraAdivinar = new char[palabraSeleccionada.length()];
                for (int i = 0; i < palabraSeleccionada.length(); i++) {
                    palabraAdivinar[i] = '-';
                }

                int intentos = 5;

                while (intentos > 0) {
                    dos.println(String.valueOf(palabraAdivinar) + ":" + intentos);
                    String letra = dis.readLine().toUpperCase();

                    if (palabraSeleccionada.contains(letra)) {
                        for (int i = 0; i < palabraSeleccionada.length(); i++) {
                            if (palabraSeleccionada.charAt(i) == letra.charAt(0)) {
                                palabraAdivinar[i] = letra.charAt(0);
                            }
                        }
                    } else {
                        intentos--;
                    }

                    if (!String.valueOf(palabraAdivinar).contains("-")) {
                        dos.println("¡Felicidades! ¡Has ganado!");
                        break;
                    }
                }

                if (intentos == 0) {
                    dos.println("¡Has perdido! La palabra era: " + palabraSeleccionada);
                }

                s.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
