package Dump;

public class CheckOneIsPermutationOfAnother {

    public static boolean checkOneIsPermutationOfAnother(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return checkOneIsPermutationOfAnother(str2, str1);
        }

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
//            if (str2.contains(c))
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
