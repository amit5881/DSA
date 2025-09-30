package LeetCodeDaily;

public class LargestPerimeterTriangle976 {

    public static int largestPerimeter(int[] nums) {
        int n = nums.length;;

        selectAndSwapMax(nums, n - 1);
        selectAndSwapMax(nums, n - 2);

        for (int i = n - 1; i >= 2; i--) {
            selectAndSwapMax(nums, i - 2);
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }

    private static void selectAndSwapMax(int[] nums, int idx) {
        int maxValue = nums[0];
        int maxIndex = 0;

        for (int i = 0; i <= idx; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }

        int temp = nums[idx];
        nums[idx] = maxValue;
        nums[maxIndex] = temp;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{2, 1, 2}));
    }
}
