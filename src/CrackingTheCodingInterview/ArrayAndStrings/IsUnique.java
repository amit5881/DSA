package CrackingTheCodingInterview.ArrayAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public static boolean isUniqueUsingSet(String str) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (characterSet.contains(str.charAt(i))) {
                return false;
            }
            characterSet.add(str.charAt(i));
        }
        return true;
    }

    public static boolean isUniqueUsingBitVector(String str) {
        int checker = 0;
        for (char c : str.toCharArray()) {
            int val = c - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }

    public static boolean isUniqueWithoutExtraSpace(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i - 1] == charArr[i]) return false;
        }
        return true;
    }

    public static boolean isUniqueChars(String str) {
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    public static boolean isUniqueCharsUsingBitVector(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (i << val)) > 0) return false;
            checker |= 1 << val;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "amit";          // try longer strings for clearer timings
        int runs = 100000;              // run each many times to average out noise

        measure("isUniqueUsingSet", runs, () -> isUniqueUsingSet(input));
        measure("isUniqueUsingBitVector", runs, () -> isUniqueUsingBitVector(input));
        measure("isUniqueWithoutExtraSpace", runs, () -> isUniqueWithoutExtraSpace(input));
        measure("isUniqueChars", runs, () -> isUniqueChars(input));
        measure("isUniqueCharsUsingBitVector", runs, () -> isUniqueCharsUsingBitVector(input));
    }

    private static void measure(String name, int runs, Runnable method) {
        long start = System.nanoTime();
        for (int i = 0; i < runs; i++) method.run();
        long end = System.nanoTime();
        double avgNs = (end - start) / (double) runs;
        System.out.printf("%-30s : %.2f ns average%n", name, avgNs);
    }
}
