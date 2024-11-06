package Arrays;

import java.util.Arrays;

public class FindHighestAltitude {

    public static int findHighest(int[] arr) {
        int[] result = new int[arr.length + 1];
        result[0] = 0;
        int resIndex = 1;
        for (int i : arr) {
            result[resIndex] = result[resIndex - 1] + i;
            resIndex++;
        }

        return Arrays.stream(result).max().getAsInt();
    }

    public static int betterSolution(int[] arr) {
        int sum = 0;
        int maxSum = 0;
        for (int j : arr) {
            sum += j;
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(findHighest(new int[] {-5,1,5,0,-7}));
        System.out.println(betterSolution(new int[] {-5,1,5,0,-7}));
        System.out.println(findHighest(new int[] {-4,-3,-2,-1,4,3,2}));
        System.out.println(betterSolution(new int[] {-4,-3,-2,-1,4,3,2}));
    }
}
