package CodingMinutes.Strings;

public class DigitsAndSpaces {

    public static void digitsAndSpaces(String str) {
        int alphabet = 0;
        int space = 0;
        int digit = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                digit++;
            } else if (Character.isLetter(ch)) {
                alphabet++;
            } else if (Character.isSpaceChar(ch)) {
                space++;
            }
        }
        System.out.println(digit + " " + alphabet + " " + space);
    }

    public static void main(String[] args) {
        digitsAndSpaces("abc 10 bca");
    }
}
