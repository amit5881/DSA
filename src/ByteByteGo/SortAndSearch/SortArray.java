package ByteByteGo.SortAndSearch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SortArray {

    public static int[] sortArray(int[] nums) {
        quickSortOptimised(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int lo = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swapElements(nums, lo, i);
                lo++;
            }
        }
        swapElements(nums, lo, right);
        return lo;
    }

    private static void swapElements(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // quick sort optimised

    private static void quickSortOptimised(int[] nums, int left, int right) {
        if (left >= right) return;
        int randomIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        swapElements(nums, randomIndex, right);

        int pivotIndex = partition(nums, left, right);
        quickSortOptimised(nums, left, pivotIndex - 1);
        quickSortOptimised(nums, pivotIndex + 1, right);
    }

    // counting sort

    private static int[] countingSort(int[] nums) {
        if (nums.length == 0) return new int[]{};

        int[] result = new int[nums.length];
        int[] counts = new int[Arrays.stream(nums).max().getAsInt() + 1];

        for (int num : nums) {
            counts[num]++;
        }

        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                result[idx++] = i;
                counts[i]--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] { 6, 8, 4, 2, 7, 3, 1, 5 })));
        System.out.println(Arrays.toString(countingSort(new int[] { 6, 8, 4, 2, 7, 3, 1, 5 })));
    }
}
