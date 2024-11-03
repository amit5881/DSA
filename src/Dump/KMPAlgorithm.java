package Dump;

public class KMPAlgorithm {

    private static boolean solution(String text, String pattern) {
        int i = 0;

        for (int j = 0; j < pattern.length(); j++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
            } else {
                i = 0;
            }
        }

        return i == pattern.length();
    }

    public static void main(String[] args) {
        String text = "ABABCABCABABABD";
        String pattern = "ABABD";

        boolean isPatternFound = solution(text, pattern);
        System.out.println(isPatternFound);
    }

}
