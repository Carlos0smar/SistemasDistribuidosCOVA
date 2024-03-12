package org.example.Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class ClientHandler extends Thread {
    int score = 0;
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    HashMap<Integer, String> answers;
    List<String> questions;
    int questionIndex = 0;

    Random random = new Random();


    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
        this.answers = new HashMap<>();
        this.questions = new ArrayList<>();
    }

    @Override
    public void run() {
        String received;
        loadQuestions();
        while (true) {
            try {
                // Ask user what he wants
                questionIndex = random.nextInt(questions.size());
                dos.writeUTF(questions.get(questionIndex));
//                dos.writeUTF("Write a message to other clients :");
                // receive the answer from client
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                validateAnswer(received);
                ServerMultiHilo.score();

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

    public void validateAnswer(String received) throws IOException {
        if(received.equals(answers.get(questionIndex))) {
            score++;
            dos.writeUTF("Correcto");
        } else {
            dos.writeUTF("Incorrecto");
        }
    }

    public void loadQuestions(){
        answers.put(0, "Paris");
        answers.put(1, "Madrid");
        answers.put(2, "Berlin");
        answers.put(3, "Roma");
        answers.put(4, "Sucre");
        answers.put(5, "Buenos Aires");
        answers.put(6, "Brasilia");
        answers.put(7, "Santiago");
        answers.put(8, "Bogota");
        answers.put(9, "Quito");


        questions.add("¿Cuál es la capital de Francia?");
        questions.add("¿Cuál es la capital de España?");
        questions.add("¿Cuál es la capital de Alemania?");
        questions.add("¿Cuál es la capital de Italia?");
        questions.add("¿Cuál es la capital de Bolivia?");
        questions.add("¿Cuál es la capital de Argentina?");
        questions.add("¿Cuál es la capital de Brasil?");
        questions.add("¿Cuál es la capital de Chile?");
        questions.add("¿Cuál es la capital de Colombia?");
        questions.add("¿Cuál es la capital de Ecuador?");
    }


}
