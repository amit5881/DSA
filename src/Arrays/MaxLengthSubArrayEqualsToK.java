package Arrays;

public class MaxLengthSubArrayEqualsToK {

    public static int maxLengthSubArray(int[] arr, int target) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int length = 0;
                int currentSum = 0;
                for (int k = i; k <= j; k++) {
                    currentSum += arr[k];
                    length++;
                    if (currentSum == target) {
                        maxLength = Math.max(maxLength, length);
                    }
                }
            }
        }
        return maxLength;
    }

    public static int maxLengthSubArrayOptimised(int[] arr, int target) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];
                if (currentSum == target) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthSubArrayOptimised(new int[] {1,2,3,1,1,1,1,4,2,3}, 3));
        System.out.println(maxLengthSubArrayOptimised(new int[] {2,3,5}, 5));
        System.out.println(maxLengthSubArrayOptimised(new int[] {2,3,5,1,9}, 10));
    }
}
