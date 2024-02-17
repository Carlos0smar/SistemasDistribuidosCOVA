package cova.assingment.firstexercise;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static boolean isRunning = true;
    public static void main(String[] args) {

        while (isRunning) {
            menu();
            String optionSelected = sc.next();
            options(optionSelected);
        }
    }

    public static void menu() {
        System.out.println("a. Fibonacci");
        System.out.println("b. Factorial");
        System.out.println("c. exit");
    }

    public static void options(String optionSelected) {
        int n ;
        switch(optionSelected){
            case "a":
                System.out.println("Fibonacci");
                System.out.println("Insert a number:");
                n = sc.nextInt();
                System.out.println("Fibonacci of " + n + " is " + Operations.fibonacci(n));
                break;
            case "b":
                System.out.println("Factorial");
                System.out.println("Insert a number:");
                n = sc.nextInt();
                System.out.println("Factorial of " + n + " is " + Operations.factorial(n));
                break;
            case "c":
                System.out.println("exit");
                break;
            default:
                System.out.println("Invalid option");
                break;

        }
    }

}