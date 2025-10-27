package CrackingTheCodingInterview.ArrayAndStrings;

import java.util.Arrays;

public class URLify {

    public static String urlify(String str) {
        str = str.trim();
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String urlifyInPlace(char[] str, int trueLength) {
        int i = str.length - 1;
        int extra = str.length - trueLength;
        int j = i - extra;
        while (i != j) {
            if (Character.isSpaceChar(str[j])) {
                str[i--] = '0';
                str[i--] = '2';
                str[i--] = '%';
                j--;
            } else {
                str[i--] = str[j--];
            }
        }
        return Arrays.toString(str);
    }

    public static void replaceChars(char[] str, int trueLength) {
        int spaceCount = 0, index = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ') spaceCount++;
        }
        index = trueLength + spaceCount * 2;
        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index -= 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(urlify("Mr John Smith      "));
        System.out.println(urlifyInPlace("Mr John Smith    ".toCharArray(), 13));
        char[] input = "Mr John Smith    ".toCharArray();
        replaceChars(input, 13);
        System.out.println(new String(input));
    }
}
