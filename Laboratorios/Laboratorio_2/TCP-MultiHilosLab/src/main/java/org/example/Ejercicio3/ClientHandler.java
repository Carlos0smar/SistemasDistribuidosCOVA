package org.example.Ejercicio3;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ClientHandler extends Thread {
    final DataInputStream dis;
    final ObjectOutputStream dos;
    final Socket s;
    private Operations operations;


    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, ObjectOutputStream dos, Operations operations) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.operations = operations;
    }

    @Override
    public void run() {
        String received;
        while (true) {
            try {

                // receive the answer from client
                received = dis.readUTF();

                operationToPerform(received);

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

//                readOperation();
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

    public void  operationToPerform(String received){
        switch (received){
            case "1":
                addOperation();
                break;
            case "2":
                removeOperation();
                break;
            case "3":
                readOperation();
                break;
        }
    }

    public void addOperation(){
        try {
            String name =  dis.readUTF();
            String description = dis.readUTF();
            operations.addTask(name, description);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeOperation(){
        try {
            String name =  dis.readUTF();
            operations.removeTask(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOperation(){
        try {
            List<Task> tasks = operations.getTasks();
            dos.writeObject(tasks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
