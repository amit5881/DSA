package Strings;

public class MergeStringAlternatively {

    public static String mergeStringAlternatively(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str1.length() || i < str2.length()) {
            if (i < str1.length()) result.append(str1.charAt(i));
            if (i < str2.length()) result.append(str2.charAt(i));
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeStringAlternatively("ab", "pqrs"));
    }
}
