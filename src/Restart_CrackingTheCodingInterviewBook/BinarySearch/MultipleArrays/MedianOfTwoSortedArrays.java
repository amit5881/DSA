package Restart_CrackingTheCodingInterviewBook.BinarySearch.MultipleArrays;

public class MedianOfTwoSortedArrays {

    public static double solution(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) return solution(nums2, nums1);

        int left = 0, right = n1;
        int mid = (n1 + n2 + 1) / 2;
        int n = n1 + n2;

        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = mid - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n1) r1 = nums1[mid1];
            if (mid2 < n2) r2 = nums2[mid2];
            if (mid1 - 1 >= 0) l1 = nums1[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = nums2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) return (double) (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2.0;
                else return Integer.max(l1, l2);
            } else if (l1 > r2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{0, 2, 5, 6, 8}, new int[]{1, 3, 7}));
    }
}
