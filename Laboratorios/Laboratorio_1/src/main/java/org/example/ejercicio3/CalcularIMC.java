package org.example.ejercicio3;
import java.util.Scanner;

public class CalcularIMC {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Calculadora de IMC");
        System.out.print("Ingrese su peso en kilogramos: ");
        double peso = scanner.nextDouble();

        System.out.print("Ingrese su altura en metros: ");
        double altura = scanner.nextDouble();


        double imc = calcularIMC(peso, altura);

        System.out.println("Su IMC es: " + imc);
        System.out.println("Clasificación:");

        if (imc < 18.5) {
            System.out.println("Bajo peso");
        } else if (imc >= 18.5 && imc < 25) {
            System.out.println("Peso normal");
        } else if (imc >= 25 && imc < 30) {
            System.out.println("Sobrepeso");
        } else {
            System.out.println("Obesidad");
        }

    }


    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }


}
