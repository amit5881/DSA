package Arrays;

public class SubArraySumDivisibleByK {

    public static int subArraySumDivisibleByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (k % currentSum == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subArraySumDivisibleByK(new int[] {4,5,0,-2,-3,1}, 5));
    }
}
