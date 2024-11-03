package CodingMinutes.Arrays;

public class LowerBound {

    public static int lowerBound(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;

        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= val) {
                ans = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1, 2, 3, 4, 6}, 3));
    }
}
