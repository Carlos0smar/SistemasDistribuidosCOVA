package org.example.ejercicio4;

import java.util.Scanner;

public class Operaciones {
    public static void suma(double num1, double num2) {
        double resultado = num1 + num2;
        System.out.println("El resultado de la suma es: " + resultado);
    }

    public static void resta(double num1, double num2) {
        double resultado = num1 - num2;
        System.out.println("El resultado de la resta es: " + resultado);
    }

    public static void multiplicacion(double num1, double num2) {
         double resultado = num1 * num2;
        System.out.println("El resultado de la multiplicación es: " + resultado);
    }

    public static void division(double numerador, double denominador) {

        if (denominador == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
        } else {
            double resultado = numerador / denominador;
            System.out.println("El resultado de la división es: " + resultado);
        }
    }

    public static void potencia(double base, double exponente) {

        double resultado = Math.pow(base, exponente);
        System.out.println("El resultado de la potencia es: " + resultado);
    }

    public static void raizCuadrada(double numero) {

        if (numero < 0) {
            System.out.println("Error: No se puede calcular la raíz cuadrada de un número negativo.");
        } else {
            double resultado = Math.sqrt(numero);
            System.out.println("La raíz cuadrada es: " + resultado);
        }
    }
}
