/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 * @author Carlos
 */

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, NotBoundException {

        Scanner sc = new Scanner(System.in);
        IRegistroAlumnos registro;
        registro = (IRegistroAlumnos) Naming.lookup("rmi://localhost/RegistroAlumnos"); // instanciar un objeto remoto
        int opcion = 0;
        while (opcion != 3) {
            menu();
            opcion = sc.nextInt();
            options(opcion, registro);
        }
    }


    public static void options(Integer option, IRegistroAlumnos registro) throws RemoteException {
        switch (option){
            case 1:
                Alumno alumno = registro.registrarAlumno(createAlumno());
                System.out.println(alumno.toString());
                break;
            case 2:
                listarAlumnos(registro.listarAlumnos());
                break;
            case 3:
                System.out.println("programa finalizado");
                break;
        }
    }

    public static Alumno createAlumno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre(s)");
        String nombre = scanner.next();
        System.out.println("Introduzca el apellido(s)");
        String apellido = scanner.next();
        System.out.println("Introduzca el cedula de identidad(s)");
        String cedulaIdentidad = scanner.next();
        System.out.println("Introduzca el carnet universitario(s)");
        String carnetUni = scanner.next();
        return new Alumno(nombre, apellido, cedulaIdentidad, carnetUni);
    }

    public static void listarAlumnos(ArrayList<Alumno> alumnos){
        for(Alumno alumno : alumnos){
            System.out.println(alumno.toString());
        }
    }
    public static void menu(){
        System.out.println("1. Crear Alumno");
        System.out.println("2. Listar Alumnos");
        System.out.println("3. Salir");
        System.out.println("---------------------------");
        System.out.println("introduzca opcion");
    }

}
