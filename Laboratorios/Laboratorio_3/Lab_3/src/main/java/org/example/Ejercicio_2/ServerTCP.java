/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example.Ejercicio_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/**
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */

    HashMap<Integer, String> palabras = new HashMap<>();
    int intentos;

    String guiones;
    String palabra;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int port = 5002;
        ServerSocket server;
        HashMap dictionary = fillDictionary();
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio la calculadora con éxito");
            Socket client;
            PrintStream toClient;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            while (true) {
                String recibido = fromClient.readLine();
                String resul = translateWord(recibido, dictionary);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(resul);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static HashMap fillDictionary() {
        HashMap<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("hola", "hello");
        dictionary.put("casa", "house");
        dictionary.put("universidad", "university");
        dictionary.put("perro", "dog");
        dictionary.put("gato", "cat");
        dictionary.put("adios", "goodbye");
        dictionary.put("oso", "bear");
        dictionary.put("rojo", "red");
        dictionary.put("azul", "blue");
        dictionary.put("verde", "green");
        dictionary.put("amarillo", "yellow");
        dictionary.put("blanco", "white");
        dictionary.put("negro", "black");
        dictionary.put("agua", "water");
        dictionary.put("fuego", "fire");
        dictionary.put("juego", "game");
        return dictionary;
    }

    public static String translateWord(String spanishWord, HashMap dictionary) {
        if (dictionary.containsKey(spanishWord)) {
            return "La tradcucion es: " + dictionary.get(spanishWord.toLowerCase()).toString();
        }
        return "The Server can't translate the word: " + spanishWord;
    }

    public void validateAnswer(String received) throws IOException {
        if (received.equals(answers.get(questionIndex))) {
            score++;
            dos.writeUTF("Correcto");
        } else {
            dos.writeUTF("Incorrecto");
        }
    }

    public void getWord(){
        Random random = new Random();
        palabra = palabras.get(random.nextInt());
    }

    public void getGuiones(){
        int palabraLong = palabra.length();
        for(int i = 0;i<= palabraLong; i++ ){
            guiones = guiones + "_ ";
        }
    }

    public void addLetras(String letra,){
        int idexLetra = palabra.indexOf(letra);
        guiones.charAt(idexLetra);
//        guiones.setCharAt(idexLetra, letra.charAt(0));


//        guiones = guiones.substring(0, idexLetra) + letra + guiones.substring(idexLetra+1);
        guiones = guiones.substring(0, idexLetra) + letra + guiones.substring(idexLetra+1);


    }
    public void loadQuestions() {
        palabras.put(0, "Paris");
        palabras.put(1, "Loro");
        palabras.put(2, "Berlin");
        palabras.put(3, "Roma");
        palabras.put(4, "Gato");
        palabras.put(5, "Perro");
        palabras.put(6, "Brasilia");
        palabras.put(7, "Silla");
        palabras.put(8, "Bogota");
        palabras.put(9, "Mesa");
    }

}
