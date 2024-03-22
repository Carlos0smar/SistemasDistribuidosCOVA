package org.example.Ejercicio_1;

public class NumeroPrimo {
    public static String isPrimo(int numero){
        if(numero <= 1){
            return "El numero " + numero + " no es primo";
        }

        for(int i = 2; i < numero; i++){
            if(numero % i == 0){
                return "El numero " + numero + " no es primo";
            }
        }

        return "El numero " + numero + " es primo";
    }
}
