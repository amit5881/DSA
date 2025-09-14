package ByteByteGo.BitManipulation;

public class SwapOddAndEvenBits {

    public static int swapOddAndEvenBits(int n) {
        int evenMask = 0X55555555;
        int oddMask = 0XAAAAAAAA;
        int evenBits = n & evenMask;
        int oddBits = n & oddMask;
        return (evenBits << 1) | (oddBits >> 1);
    }

    public static void main(String[] args) {
        System.out.println(swapOddAndEvenBits(41));
        System.out.println(swapOddAndEvenBits(23));
    }
}
