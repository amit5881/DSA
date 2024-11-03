package CodingMinutes.RecursionBasics;

import java.util.ArrayList;

public class IncreasingNumbers {

    public static ArrayList<Integer> increasingNumbers(int n) {
        if (n == 0) return new ArrayList<>();
        ArrayList<Integer> result = increasingNumbers(n - 1);
        result.add(n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(increasingNumbers(5));
    }
}
