package CodingMinutes.RecursionBasics;

public class PowerFunction {

    public static int powerFunction(int x, int n) {
        if (n == 0) return 1;
        return x * powerFunction(x, n - 1);
    }

    public static int powerFunctionOptimised(int x, int n) {
        if (n == 0) return 1;
        int subProblem = powerFunctionOptimised(x, n / 2);
        int subProblemSquare = subProblem * subProblem;
        if (n % 2 != 0) {
            return x * subProblemSquare;
        } else {
            return subProblemSquare;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerFunctionOptimised(2, 10));
    }
}
