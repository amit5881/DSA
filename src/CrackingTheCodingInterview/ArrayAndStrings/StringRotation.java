package CrackingTheCodingInterview.ArrayAndStrings;

public class StringRotation {

    // check is s2 is rotation of s1
    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();

        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }

        return false;
    }

    private static boolean isSubstring(String s1s1, String s2) {
        return s1s1.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }
}
