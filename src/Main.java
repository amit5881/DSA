import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void dutchNationalFlag(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length -1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                swapElements(arr, start, mid);
                start++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swapElements(arr, mid, end);
                end--;
            }
        }
    }

    public static void swapElements(int[] arr, int start, int mid) {
        int temp = arr[start];
        arr[start] = arr[mid];
        arr[mid] = temp;
    }

    public static void main(String[] args) {
        String input = "This:is*a.new*problem.statement:to-solve";

        // Extract words by splitting with delimiters (:, *, -, .)
        String[] words = input.split("[:*.-]");

        // Extract and keep the delimiters in a list (this regex matches the delimiters)
        List<String> delimiters = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == ':' || ch == '*' || ch == '-' || ch == '.') {
                delimiters.add(String.valueOf(ch));
            }
        }

        // Reverse the words
        List<String> reversedWords = Arrays.asList(words);
        Collections.reverse(reversedWords);

        // Rebuild the output string by interleaving words and delimiters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < reversedWords.size(); i++) {
            result.append(reversedWords.get(i));  // Append the word
            if (i < delimiters.size()) {
                result.append(delimiters.get(i));  // Append the corresponding delimiter
            }
        }

        // Output the final result
        System.out.println(result.toString());
    }
}