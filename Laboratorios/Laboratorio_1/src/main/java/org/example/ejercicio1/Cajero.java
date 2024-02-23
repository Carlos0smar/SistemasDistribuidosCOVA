package org.example.ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cajero {


    static ArrayList<Usuario> usuarios = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);


    static boolean isRunning = true;

    public static void main(String[] args) {
        createUsuarios();
        Usuario usuario = userAuth();
        if (usuario != null){
            while (isRunning) {

                menu();
                System.out.println("Choose an option");
                int option = scanner.nextInt();
                operaciones(option,usuario);

            }
        }

    }

    public static void createUsuarios() {
        Usuario usuario1 = new Usuario("Carlos", "abc");
        Usuario usuario2 = new Usuario("Pedro", "def");
        Usuario usuario3 = new Usuario("Alejandro", "ghi");

        usuario1.getCuenta().setSaldo(10.0);
        usuario2.getCuenta().setSaldo(20.0);
        usuario3.getCuenta().setSaldo(60.0);


        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

    }

    public static void menu() {
        System.out.println("1. Depositar");
        System.out.println("2. Retirar");
        System.out.println("3. Mostrar Saldo");
        System.out.println("4. Salir del Cajero");

    }

    public static void operaciones(int operation, Usuario usuario) {
        double dinero;
        switch (operation) {
            case 1:
                System.out.println("Introducir monto a depositar: ");
                dinero = scanner.nextDouble();
                usuario.getCuenta().depositarDinero(dinero);
                break;
            case 2:
                System.out.println("Introducir monto a retirar: ");
                dinero = scanner.nextDouble();
                usuario.getCuenta().reitrarDinero(dinero);
                break;
            case 3:
                usuario.getCuenta().mostrarSaldo();
                break;
            case 4:
                isRunning = false;
                break;
            default:
                System.out.println("Escoja una opción válida");
                break;

        }
    }

    public static Usuario userAuth() {
        System.out.println("Introduzca usuario");
        String user = scanner.next();
        System.out.println("Contraseña");
        String password = scanner.next();
        for (Usuario usuario : usuarios) {
            if (usuario.getName().equals(user) && usuario.getPassword().equals(password)) {
                return usuario;
            }

        }
        System.out.println("Usuario o contrasena incorrecta");
        return null;
    }

}
