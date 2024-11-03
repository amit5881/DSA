package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

    public static int findLongestChain(int[][] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int maxLength = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i][0] > arr[j][1] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{new int[] {1,2}, new int[]{7,8}, new int[]{4,5}}));
    }
}
