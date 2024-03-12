package org.example.Ejercicio3;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;
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
            ObjectInputStream dis = new ObjectInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            // the following loop performs the exchange of
            // information between client and client handler
            while (true) {

                menu();
                String toSend = scn.nextLine();
                dos.writeUTF(toSend);
                protocol(toSend, dos, dis);

                if (toSend.equals("Exit")) {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

//                showTasks(dis);
            }

            // closing resources
            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void protocol(String toSend, DataOutputStream dos, ObjectInputStream dis) throws IOException, ClassNotFoundException {
        switch (toSend) {
            case "1":
                addTask(dos, dis);
                break;
            case "2":
                deleteTask(dos, dis);
                break;
            case "3":
                showTasks(dis);
                break;
        }


    }

    public static void addTask(DataOutputStream dos, ObjectInputStream dis) throws IOException, ClassNotFoundException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la tarea");
        String name = scn.nextLine();
        System.out.println("Ingrese la descripcion de la tarea");
        String description = scn.nextLine();
        dos.writeUTF(name);
        dos.writeUTF(description);

        // Solicitar la lista actualizada
        dos.writeUTF("3");
        showTasks(dis);
    }

    public static void deleteTask(DataOutputStream dos, ObjectInputStream dis) throws IOException, ClassNotFoundException {
        Scanner scn = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la tarea a eliminar");
        String name = scn.nextLine();
        dos.writeUTF(name);

        // Solicitar la lista actualizada
        dos.writeUTF("3");
        showTasks(dis);
    }

    public static void showTasks(ObjectInputStream dis) throws IOException, ClassNotFoundException {
        System.out.println("Tareas");
        List<Task> tareas = (List<Task>) dis.readObject();
        for (Task t : tareas) {
            System.out.println("Tarea #" + tareas.indexOf(t) + 1);
            System.out.println("Nombre: " + t.getName() + " Descripcion: " + t.getDescription());
        }

    }


    public static void menu() {
        System.out.println("1. Agregar tarea");
        System.out.println("2. Eliminar tarea");
        System.out.println("3. Ver tareas");
        System.out.println("4. Salir");
    }
}
