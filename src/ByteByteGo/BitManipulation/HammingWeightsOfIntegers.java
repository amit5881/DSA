package ByteByteGo.BitManipulation;

import java.util.Arrays;

public class HammingWeightsOfIntegers {

    public static int[] hammingWeightsOfIntegers(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = countBitSets(i);
        }
        return result;
    }

    private static int countBitSets(int x) {
        int count = 0;
        while (x > 0) {
            count += x & 1;   // increment the count if LSB(least significant bit) is 1
            x >>= 1;   // right shift 'x' to shift the next bit
        }
        return count;
    }

    private static int[] hammingWeightsOfIntegersDp(int n) {
        int[] dp = new int[n + 1];
        for (int x = 1; x < n + 1; x++) {
            dp[x] = dp[x >> 1] + (x & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(hammingWeightsOfIntegers(7)));
        System.out.println(Arrays.toString(hammingWeightsOfIntegersDp(7)));
    }
}
