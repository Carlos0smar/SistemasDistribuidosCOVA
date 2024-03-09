package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler extends Thread {
    long num1;
    long num2;

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;

        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("Escoge una opcion");

                // receive the answer from client
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                validarEntrada(received);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void validarEntrada(String received) throws IOException {
        String[] parts = divideString(received);
        if(parts[0].equals("iniciar")){
            operation(parts[1]);
        }

        if(parts[0].equals("respuesta")){
            if(verifyExercise(parts[1] , correctValue())){
                dos.writeUTF("Respuesta correcta");
            } else {
                dos.writeUTF("Respuesta incorrecta");
            }
        }

    }
    public void operation(String operation) throws IOException {
        switch (operation){
            case "suma":
                num1 = generateRandomExercise();
                num2 = generateRandomExercise();
                generateExercise();
                dos.writeUTF("Ej: " + generateExercise());
                break;
        }
    }


    public long generateRandomExercise(){
        return Math.round(Math.random() * 100);
    }


    public long correctValue (){
        return num1 + num2;
    }

    public String generateExercise(){
        String exercise = ( num1 + "+" + num2);
        return exercise;
    }

    public boolean verifyExercise(String resutado, long correctValue){
        if(Integer.parseInt(resutado) == correctValue){
            return true;
        }
        return false;
    }
    String[] divideString(String cadena){
        String[] parts = cadena.split(":");
        return parts;
    }

}
