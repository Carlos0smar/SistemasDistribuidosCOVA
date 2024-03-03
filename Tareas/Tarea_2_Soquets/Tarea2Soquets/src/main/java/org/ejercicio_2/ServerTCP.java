/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */



    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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
            while (true){
                String recibido=fromClient.readLine();
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

    public static String translateWord(String spanishWord, HashMap dictionary){
        if(dictionary.containsKey(spanishWord)){
            return "La tradcucion es: " + dictionary.get(spanishWord.toLowerCase()).toString();
        }
        return "The Server can't translate the word: " + spanishWord;
    }
}
