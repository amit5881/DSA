package Strings;

public class CompressString {

    /*
    aabbc => a2b2c
     */
    public static String solution(String str) {
        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = str.charAt(i - 1);

            if (current == prev) {
                count++;
            } else {
                if (count > 1) {
                    result.append(count);
                    count = 1;
                }
                result.append(current);
            }
        }

        if (count > 1) result.append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbbcc"));
    }
}
