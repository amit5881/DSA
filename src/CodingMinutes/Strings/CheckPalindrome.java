package CodingMinutes.Strings;

public class CheckPalindrome {

    public static void main(String[] args) {
        boolean isPalindrome = checkPalindrome("acbca");
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
