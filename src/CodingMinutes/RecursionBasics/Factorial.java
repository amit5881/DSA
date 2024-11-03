package CodingMinutes.RecursionBasics;

import java.util.Scanner;

public class Factorial {

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(factorial(scanner.nextInt()));
    }
}
