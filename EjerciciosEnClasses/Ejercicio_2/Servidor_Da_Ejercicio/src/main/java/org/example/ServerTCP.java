/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Carlos
 */
public class ServerTCP {

    /**
     * @param args the command line arguments
     */
    static long num1;
    static long num2;
    static PrintStream toClient;
    static BufferedReader fromClient;
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int port = 5002;
        ServerSocket server;
        try {
            server = new ServerSocket(port);
            System.out.println("Se inicio la calculadora con éxito");
            Socket client;
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            toClient = new PrintStream(client.getOutputStream());
            System.out.println("Cliente se conecto");
            while (true){
                String recibido=fromClient.readLine();
                validarEntrada(recibido);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void validarEntrada(String received) {
        String[] parts = divideString(received);
        if(parts[0].equals("iniciar")){
            operation(parts[1]);
        }

        if(parts[0].equals("respuesta")){
            if(verifyExercise(parts[1] , correctValue())){
                toClient.println("Respuesta correcta");
            } else {
                toClient.println("Respuesta incorrecta");
            }
        }

    }

    public static void operation(String operation) {
        switch (operation){
            case "suma":
                num1 = generateRandomExercise();
                num2 = generateRandomExercise();
                generateExercise();
                toClient.println("Ej: " + generateExercise());
                break;
        }
    }


    public static long generateRandomExercise(){
        return Math.round(Math.random() * 100);
    }


    public static long correctValue(){
        return num1 + num2;
    }

    public static String generateExercise(){
        String exercise = ( num1 + "+" + num2);
        return exercise;
    }

    public static boolean verifyExercise(String resutado, long correctValue){
        if(Integer.parseInt(resutado) == correctValue){
            return true;
        }
        return false;
    }
    static String[] divideString(String cadena){
        String[] parts = cadena.split(":");
        return parts;
    }

}
