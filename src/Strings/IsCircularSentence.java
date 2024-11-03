package Strings;

public class IsCircularSentence {

    public static boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        if (split.length == 1) {
            if (split[0].charAt(0) != split[0].charAt(split[0].length() - 1)) {
                return false;
            }
        }
        for (int i = 1; i < split.length; i++) {
            if (split[i - 1].charAt(split[i - 1].length() - 1) != split[i].charAt(0)) {
                return false;
            }
        }
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;
        return true;
    }

    public static boolean betterSolution(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) return false;

        int k = sentence.indexOf(" ");
        if (k == -1) return true;

        while (k != -1) {
            if (sentence.charAt(k - 1) != sentence.charAt(k + 1)) return false;
            k = sentence.indexOf(" ", k + 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(betterSolution("leetcode exercises sound delightful"));
        System.out.println(betterSolution("eetcode"));
        System.out.println(betterSolution("Leetcode eisc cool"));

    }
}
