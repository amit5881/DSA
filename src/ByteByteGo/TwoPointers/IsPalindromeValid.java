package ByteByteGo.TwoPointers;

public class IsPalindromeValid {

    private static boolean isPalindromeValidSkipNonAlphanumeric(String str) {
        int start  = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (isNotCharacterAlphanumeric(str.charAt(start))) {
                start++;
            } else if (isNotCharacterAlphanumeric(str.charAt(end))) {
                end--;
            } else if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean isNotCharacterAlphanumeric(char ch) {
        return (ch < 'a' || ch > 'z') &&
                (ch < 'A' || ch > 'Z') &&
                (ch < '0' || ch > '9');
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeValidSkipNonAlphanumeric(""));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("a"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("aa"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("ab"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("!, (?)"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("12.02.2021"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("21.02.2021"));
        System.out.println(isPalindromeValidSkipNonAlphanumeric("hello, world!"));
    }
}
