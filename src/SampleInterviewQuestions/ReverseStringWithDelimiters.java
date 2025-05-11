package SampleInterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class ReverseStringWithDelimiters {

    public static String reverseWithDelimiters(String s) {
        // Node to store words and delimiters
        List<String> parts = new ArrayList<>();

        // Temporary StringBuilder to collect a word
        StringBuilder temp = new StringBuilder();

        // Loop through the input string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if the character is alphanumeric
            if (Character.isLetterOrDigit(ch)) {
                // Append character to the current word
                temp.append(ch);
            } else {
                // If we encounter a delimiter and the temp has a word, add the word to the parts
                if (temp.length() > 0) {
                    parts.add(temp.toString());
                    temp.setLength(0); // Clear the StringBuilder for the next word
                }
                // Add the delimiter to the parts
                parts.add(String.valueOf(ch));
            }
        }

        // Add the last word if there is any left in temp
        if (temp.length() > 0) {
            parts.add(temp.toString());
        }

        // Collect the words from the list (ignoring delimiters)
        List<String> words = new ArrayList<>();
        for (String part : parts) {
            if (part.matches("\\w+")) { // If part is a word
                words.add(part);
            }
        }

        // Reverse the words list
        int wordIdx = words.size() - 1;

        // Rebuild the string by replacing words in their positions, preserving delimiters
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            if (part.matches("\\w+")) {
                result.append(words.get(wordIdx--)); // Add reversed words
            } else {
                result.append(part); // Add delimiters as is
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String string = "This:is*a.new*problem.statement:to-solve";

        System.out.println(reverseWithDelimiters(string));
    }
}
