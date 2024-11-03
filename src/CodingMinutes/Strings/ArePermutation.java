package CodingMinutes.Strings;

public class ArePermutation {

    private static boolean isPermutation(String str1, String str2) {
        if (str2.length() < str1.length()) {
            isPermutation(str2, str1);
        }

        boolean globalFlag = true;
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            boolean localFlag = false;
            for (int j =  i + 1; j < str2.length(); j++) {
                char ch2 = str2.charAt(j);
                if (ch == ch2) {
                    localFlag = true;
                }
            }
            if (!localFlag) {
                globalFlag = false;
            }
        }
        return globalFlag;
    }

    public static void main(String[] args) {
        boolean isPermutation = isPermutation("test", "sett");
        System.out.println(isPermutation);
    }
}
