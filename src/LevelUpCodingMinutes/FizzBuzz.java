package LevelUpCodingMinutes;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz {

    public static ArrayList<String> fizzbuzz(int n) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fizzbuzz(15));
    }
}
