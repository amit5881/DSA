package ByteByteGo.MathAndGeometry;

public class Reverse32BitInteger {

    public static int reverse32BitInteger(int n) {
        int INT_MAX = (int) Math.pow(2, 31) - 1;
        int INT_MIN = (int) - Math.pow(2, 32);
        int reversedN = 0;

        while (n != 0) {
            int digit = n % 10;
            n /= 10;

            if (reversedN > INT_MAX / 10 || reversedN < INT_MIN / 10) return 0;
            reversedN = reversedN * 10 + digit;
        }
        return reversedN;
    }

    public static void main(String[] args) {
        System.out.println(reverse32BitInteger(420));
        System.out.println(reverse32BitInteger(-15));
    }
}
