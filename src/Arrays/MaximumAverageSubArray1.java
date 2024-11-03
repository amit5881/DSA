package Arrays;

public class MaximumAverageSubArray1 {

    public static double maximumAverageSubArray(int[] arr, int k) {
        double ans;
        double window = 0;

        for (int i = 0; i < k; i++) {
            window += arr[i];
        }

        ans = window / k;

        for (int i = k; i < arr.length; i++) {
            window += arr[i] - arr[i - k];
            ans = Math.max(ans, window / k);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumAverageSubArray(new int[]{1,12,-5,-6,50,3}, 4));
    }
}
