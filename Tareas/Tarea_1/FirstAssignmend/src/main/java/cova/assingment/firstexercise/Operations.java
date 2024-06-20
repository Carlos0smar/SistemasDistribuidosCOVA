package cova.assingment.firstexercise;

public class Operations {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int[] fibonacciOptimal(int n) {
        if (n <= 1) {
            int[] answer = {n, 0};
            return answer;
        }

        int[] temp = fibonacciOptimal(n - 1);
        int[] answer = {temp[0] + temp[1], temp[0]};
        return answer;
    }

    public static int factorial(int n) {

        int resul = 1;

        for (int i = 1; i <= n; i++) {

            resul = resul * i;
        }

        return resul;

    }

}
