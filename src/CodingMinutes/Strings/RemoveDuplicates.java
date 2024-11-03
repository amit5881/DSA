package CodingMinutes.Strings;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {
        HashSet<Character> charSet = new HashSet<>();

        for (char ch : str.toCharArray()) {
            charSet.add(ch);
        }


        return charSet.toString();
    }

    public static String removeDuplicatesString(String str) {
        StringBuilder result = new StringBuilder(str.length());
        int[] frequency = new int[256];

        for (char ch : str.toCharArray()) {
            if (frequency[ch] == 0) {
                result.append(ch);
                frequency[ch]++;
            }
        }

        char[] res = result.toString().toCharArray();
        Arrays.sort(res);

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesString("geeksforgeeks"));
    }
}
