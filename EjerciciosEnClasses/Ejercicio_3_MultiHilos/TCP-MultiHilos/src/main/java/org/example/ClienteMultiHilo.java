package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClienteMultiHilo {
    public static void main(String[] args) throws IOException {
        try {
            Scanner scn = new Scanner(System.in);

            // getting localhost ip
            InetAddress ip = InetAddress.getByName("localhost");

            // establish the connection with server port 5056
            Socket s = new Socket(ip, 5056);

            // obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {
                System.out.println(dis.readUTF());
                menu();
                String tosend = scn.nextLine();
                tosend = protocoloManager(tosend);
                dos.writeUTF(tosend);


                // If client sends exit,close this connection
                // and then break from the while loop
                if (tosend.equals("Exit")) {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // printing date or time as requested by client
                String received = dis.readUTF();
                System.out.println(received);

            }

            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
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

    public static String responseRespuesta(){
        Scanner scn = new Scanner(System.in);
        System.out.println("Escriba el resultado de la suma");
        String resul = scn.next();
        return "respuesta:" + resul;
    }

    public static String responseExercise(String received){
        return "iniciar:" + received;
    }
}
