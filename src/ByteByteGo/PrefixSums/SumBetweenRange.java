package ByteByteGo.PrefixSums;

public class SumBetweenRange {

    public static int sumBetweenRange(int[] nums, int i, int j) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int k = 1; k < nums.length; k++) prefixSum[k] = nums[k] + prefixSum[k - 1];

        return (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
    }

    public static void main(String[] args) {
        System.out.println(sumBetweenRange(new int[]{ 3, -7, 6, 0, -2, 5 }, 0, 3));
        System.out.println(sumBetweenRange(new int[]{ 3, -7, 6, 0, -2, 5 }, 2, 4));
        System.out.println(sumBetweenRange(new int[]{ 3, -7, 6, 0, -2, 5 }, 2, 2));
    }
}
