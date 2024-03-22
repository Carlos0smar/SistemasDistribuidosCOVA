package org.example.Ejercicio_2;

import java.io.*;
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


            PrintWriter dos = new PrintWriter(s.getOutputStream(), true);
            BufferedReader dis = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            String fromServer;
            String fromUser;

            while ((fromServer = dis.readLine()) != null) {
                System.out.println(fromServer);

                if (fromServer.startsWith("¡Felicidades!") || fromServer.startsWith("¡Has perdido!")) {
                    break;
                }

                fromUser = stdIn.readLine();
                dos.println(fromUser);
            }

            dos.close();
            dis.close();
            stdIn.close();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
