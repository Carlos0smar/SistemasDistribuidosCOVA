package org.example;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;


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
