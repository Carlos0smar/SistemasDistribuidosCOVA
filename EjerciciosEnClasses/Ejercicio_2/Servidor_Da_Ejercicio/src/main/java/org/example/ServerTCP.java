/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.ejercicio_1;

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
    public static void main(String[] args) {


        Scanner sc=new Scanner(System.in);
        int port = 5002;
        ServerSocket server;
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
                String exercise = procesarPeticion(recibido);
                toClient = new PrintStream(client.getOutputStream());
                toClient.println(exercise);

                String resultadoExercise = fromClient.readLine();
                String resltadoVerificado = verifyExercise(resultadoExercise, correctValue());
                toClient.println(resltadoVerificado);

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static String generateExercise(){
        String exercise = ( num1 + "+" + num2);
        return exercise;
    }

    public static long generateRandomExercise(){
        return Math.round(Math.random() * 100);
    }

    public static long correctValue(){
        return num1 + num2;
    }


    public static String verifyExercise(String resutado, long correctValue){
        if(Integer.parseInt(resutado) == correctValue){
            return "The answer is correct";
        } else {
            return "The answer is wrong";
        }
    }

    public static String procesarPeticion(String cadena){
        String[] comando = cadena.split(":");
        if(comando[0].equals("inicar")){
            num1= generateRandomExercise();
            num2= generateRandomExercise();
            String responseExercise = generateExercise();
            return responseExercise;
        }

        int resultado = Integer.parseInt(comando[1]);
        if(resultado)

        }
    }


}
