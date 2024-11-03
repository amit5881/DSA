package CodingMinutes.Strings;

import java.util.*;

public class GroupAnagrams {

    private static List<List<String>> groupAnagram(String[] strs) {
       Map<String, List<String>> result = new HashMap<>();

        for (String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            String key = new String(str);

            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(s);
        }

        return result.values().stream().toList();
    }


    public static void main(String[] args) {
        List<List<String>> answer = groupAnagram(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        System.out.println(answer);
    }


}
