package CodingMinutes.Strings;

public class BinaryStringToNumber {

    public static int binaryToDecimal(String s) {
        return Integer.parseInt(s, 2);
    }

    public static void main(String[] args) {
        System.out.println(binaryToDecimal("1010"));
    }
}
