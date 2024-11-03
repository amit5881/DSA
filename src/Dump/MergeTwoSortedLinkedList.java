package Dump;

import java.util.Arrays;

public class MergeTwoSortedLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int index = 0;
        for (int j : nums1) {
            result[index++] = j;
        }
        for (int j : nums2) {
            result[index++] = j;
        }

        Arrays.sort(result);

        double ans;
        if (result.length % 2 == 0) {
            // Even-length array
            double lowerMiddle = result[(result.length / 2) - 1];
            double upperMiddle = result[result.length / 2];

            System.out.println(lowerMiddle + " :: " + upperMiddle);

            ans = (lowerMiddle + upperMiddle) / 2;
        } else {
            // Odd-length array
            ans = result[result.length / 2];
        }

        return ans;
    }

//    public static double findMedianSortedArraysOptimised(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return findMedianSortedArraysOptimised(nums2, nums1);
//        }
//
//
//    }

    public static void main(String[] args) {
        Node head1 = new Node(1, new Node(2, new Node(4, null)));
        Node head2 = new Node(1, new Node(3, new Node(4, null)));

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
