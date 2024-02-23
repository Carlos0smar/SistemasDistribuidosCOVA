package org.example.ejercicio4;

import java.util.Scanner;

public class Calculadora {

    static boolean isRunnign = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (isRunnign) {

            menu();
            System.out.print("Ingrese su elección: ");
            int opcion = scanner.nextInt();
            options(opcion);
        }
    }


    public static void menu() {
        System.out.println("Calculadora Científica");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Potencia");
        System.out.println("6. Raíz Cuadrada");
        System.out.println("7. Salir");
    }

    public static void options(int opcion) {
        switch (opcion) {
            case 1:
                callSuma();
                break;
            case 2:
                callResta();
                break;
            case 3:
                callMultiplicacion();
                break;
            case 4:
                callDivision();
                break;
            case 5:
                callPotencia();
                break;
            case 6:
                callRaizCuadrada();
                break;
            case 7:
                isRunnign = false;
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void callSuma() {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        Operaciones.suma(num1, num2);
    }

    public static void callResta() {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        Operaciones.resta(num1, num2);
    }

    public static void callMultiplicacion() {
        System.out.print("Ingrese el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Ingrese el segundo número: ");
        double num2 = scanner.nextDouble();
        Operaciones.multiplicacion(num1, num2);
    }

    public static void callDivision() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numerador: ");
        double numerador = scanner.nextDouble();
        System.out.print("Ingrese el denominador: ");
        double denominador = scanner.nextDouble();
        Operaciones.division(numerador, denominador);
    }

    public static void callPotencia() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese el exponente: ");
        double exponente = scanner.nextDouble();
        Operaciones.potencia(base, exponente);
    }

    public static void callRaizCuadrada() {

        System.out.print("Ingrese el número: ");
        double numero = scanner.nextDouble();

        Operaciones.raizCuadrada(numero);
    }

}
