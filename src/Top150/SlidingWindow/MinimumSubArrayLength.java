package Top150.SlidingWindow;

public class MinimumSubArrayLength {

    public static int minimumSubArrayLength(int[] arr, int target) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int ans = 0;
        int maxLength = Integer.MAX_VALUE;
        while (r < n) {
            ans += arr[r];
            while (ans >= target) {
                ans -= arr[l];
                maxLength = Math.min(r - l + 1, maxLength);
                l++;
            }
            r++;
        }
        return maxLength == Integer.MAX_VALUE ? 0 : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(minimumSubArrayLength(new int[] {2,3,1,2,4,3}, 7));
    }
}
