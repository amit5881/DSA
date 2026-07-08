package Restart_CrackingTheCodingInterviewBook.TwoPointers;

public class IsPalindromeValid {

    public static boolean isValid(String string) {
        int left = 0, right = string.length() - 1;
        while (left < right) {
            while (left < right && (!Character.isLetterOrDigit(string.charAt(left)))) {
                left++;
            }
            while (left < right && (!Character.isLetterOrDigit(string.charAt(right)))) {
                right--;
            }
            if (Character.toLowerCase(string.charAt(left)) != Character.toLowerCase(string.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("a dog! a panic in a pagoda."));
        System.out.println(isValid("A man, a plan, a canal: Panama"));
    }
}
