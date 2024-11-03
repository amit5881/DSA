package Java8Interview.LambdaExpression;

import java.util.*;

public class StreamAPI {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);

        List<Integer> result = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).sorted().toList();
        System.out.println(result);

        int[] arr = new int[]{1,2,3};
        System.out.println(Arrays.stream(arr).sum());

        // find the longest string in the list
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        Optional<String> ans = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

        Optional<String> combinedString = words.stream().reduce((str1, str2) -> str1 + "-" + str2);
        System.out.println(combinedString.get());

        System.out.println(ans.get());

    }
}
