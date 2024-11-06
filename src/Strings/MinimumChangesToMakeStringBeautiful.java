package Strings;

public class MinimumChangesToMakeStringBeautiful {

    public static int minimumChanges(String str) {
        int count = 0;
        if (str.isEmpty() || str.length() == 1) return count;
        for (int i = 0; i < str.length(); i += 2) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumChanges("11"));
    }
}
