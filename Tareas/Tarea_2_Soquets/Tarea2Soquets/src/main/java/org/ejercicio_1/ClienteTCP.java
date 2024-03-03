package org.ejercicio_1;


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
                    System.out.println("Introduce los valores a calcular:");
                    String cadena=sc.nextLine();
                    toServer.println(cadena);
                    String result = fromServer.readLine();
                    System.out.println("El resultado es: " + result);
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


}
