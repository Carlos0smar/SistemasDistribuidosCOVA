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
                    System.out.println("Para recibir el ejercicio Introducir iniciar:suma");
                    System.out.println("Para mandar la respuesta respuesta:(valor de la suma) ");

                    String cadena=sc.nextLine();
                    toServer.println(cadena);
                    String result = fromServer.readLine();
                    System.out.println(result);
                    System.out.println("Introduzca la respuesta");
                    String cadenaResultado=sc.nextLine();
                    toServer.println(cadenaResultado);
                    String resultadoFromServer = fromServer.readLine();
                    System.out.println(resultadoFromServer);
                }

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }


}
