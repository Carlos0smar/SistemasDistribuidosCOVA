package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;



/**
 *
 * @author Carlos
 */
public class ClienteTCP {
    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int port = 5002;
            try {
                Socket client = new Socket("localhost", port);

                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                while(true){
                    menu();
                    String cadena=sc.nextLine();
                    String valor =  protocoloManager(cadena);
                    toServer.println(valor);

                    String result = fromServer.readLine();

                    System.out.println(result);

                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    public static void menu(){
        System.out.println("1. Suma");
        System.out.println("2. Para introducir una respuesta");
        System.out.println("3. Exit");
    }

    public static String protocoloManager(String received){

        switch (received) {
            case "1":
                return responseExercise("suma");
            case "2":
                return responseRespuesta();
            case "3":
                return "Exit";
            default:
                return "";
        }
    }

    public static String responseExercise(String received){
        return "iniciar:" + received;
    }


    public static String responseRespuesta(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Escriba el resultado de la suma");
        String resul = scn.next();
        return "respuesta:" + resul;
    }

}
