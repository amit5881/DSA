package Top150.Arrays;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }
        while (i < m) {
            result[k++] = nums1[i++];
        }
        while(j < n) {
            result[k++] = nums2[j++];
        }

        if (m + n >= 0) System.arraycopy(result, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}
