package InterviewQuiestions;

public class LongestOnes {
    /*
    // Example 1
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println(sol.longestOnes(nums1, k1));  // Output: 6

        // Example 2
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        System.out.println(sol.longestOnes(nums2, k2));  // Output: 10
     */

    public static int naiveSolution(int[] arr, int k) {
        int largest = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentLargest = 0;
            int zeros = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) zeros++;
                currentLargest++;
                if (k == zeros) {
                    largest = Math.max(largest, currentLargest);
                }
            }
        }
        return largest;
    }

    public static int solution(int[] arr, int k) {
        int left = 0;
        int maxLength = 0;
        int zeros = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zeros++;

            while (zeros > k) {
                if (arr[left] == 0) zeros--;
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int[] nums = {0,0,1,1};
        int k = 2;
        System.out.println(naiveSolution(nums, k));
        System.out.println(solution(nums, k));
    }
}
