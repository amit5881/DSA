package ByteByteGo.SortAndSearch;

import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class KthLargestInteger {

    public static int kthLargestInteger(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return minHeap.peek();
    }

    public static int kthLargestIntegerQuickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        int n = nums.length;
        if (left >= right) return nums[left];

        int randomIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        swapElement(nums, right, randomIndex);

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex < n - k) {  // means n-kth element in right
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else if (pivotIndex > n - k) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return nums[pivotIndex];
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lo = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swapElement(nums, lo, i);
                lo++;
            }
        }
        swapElement(nums, lo, right);
        return lo;
    }

    private static void swapElement(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(kthLargestInteger(new int[]{ 5, 2, 4, 3, 1, 6 }, 3));
        System.out.println(kthLargestIntegerQuickSelect(new int[]{ 5, 2, 4, 3, 1, 6 }, 3));
    }
}
