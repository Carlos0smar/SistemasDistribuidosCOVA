package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int port = 5002;
            try {
                Socket client = new Socket("172.23.23.45", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));

                while(true){
                    System.out.println("Introducir el mensaje a enviar al servidor:");
                    String cadena=sc.nextLine();
                    toServer.println(cadena);
                    String result = fromServer.readLine();
                    System.out.println("Milton: " + result);
                    if(result.equals("Adios")){
                        break;
                    }
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
}
