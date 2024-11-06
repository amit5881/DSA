package Strings;

import java.util.Arrays;

public class StringCompression {

    /*
        Input: chars = ["a","a","b","b","c","c","c"]
        Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     */
    public static int solution(char[] word) {
        StringBuilder result = new StringBuilder(word[0] + "");
        int wordCount = 1;
        for (int i = 1; i < word.length; i++) {
            char current = word[i];
            char prev = word[i - 1];

            if (current == prev) {
                wordCount++;
            } else {
                if (wordCount > 1) {
                    result.append(wordCount);
                    wordCount = 1;
                }
                result.append(current);
            }
        }
        if (wordCount > 1) result.append(wordCount);
        for (int i = 0; i < result.length(); i++) {
            word[i] = result.charAt(i);
        }
        System.out.println(Arrays.toString(word));
        return result.length();
    }

    public static int betterSolution(char[] word) {
        int index = 0;
        for (int i = 0; i < word.length;) {
            char c = word[i];
            int count = 0;
            while (i < word.length && word[i] == c){
                count++;
                i++;
            }

            word[index++] = c;

            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    word[index++] = ch;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(betterSolution(new char[] {'a','a','b','b','c','c','c'}));
    }
}
