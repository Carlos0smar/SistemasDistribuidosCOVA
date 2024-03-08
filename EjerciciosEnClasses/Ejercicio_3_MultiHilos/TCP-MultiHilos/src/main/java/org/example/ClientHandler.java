package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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
        String toreturn;
        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("Introducir Suma, si quiere sumar");

                // receive the answer from client
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // creating Date object
//                Date date = new Date();

                // write on output stream based on the
                // answer from the client
                validarEntrada(received);
                
//                switch (divideString(received)) {
//
//                    case "Sum":
////                        toreturn = fordate.format(date);
//                        dos.writeUTF(toreturn);
//                        break;
//
//                    case "Time":
////                        toreturn = fortime.format(date);
//                        dos.writeUTF(toreturn);
//                        break;
//
//                    default:
//                        dos.writeUTF("Invalid input");
//                        break;
//                }
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

    public void validarEntrada(String received){
        String[] parts = divideString(received);
        if(parts[1].equals("iniciar")){
            operation(parts[2]);
        }

        if(parts[1].equals("respuesta")){
            verifyExercise(parts[2] , correctValue());
        }

    }
    public void operation(String operation){
        switch (operation){
            case "suma":
                num1 = generateRandomExercise();
                num2 = generateRandomExercise();
                generateExercise();
                dos.writeUTF("El ejercicio es: " + generateExercise());\
                break;
        }
    }

    public long generateRandomExercise(){
        return Math.round(Math.random() * 100);
    }

    public long correctValue(){
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
