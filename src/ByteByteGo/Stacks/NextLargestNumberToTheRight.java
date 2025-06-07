package ByteByteGo.Stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextLargestNumberToTheRight {

    public static int[] nextLargestNumberToTheRightBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean switched = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nums[i] = nums[j];
                    switched = true;
                    break;
                }
            }
            if (!switched) nums[i] = -1;
        }
        return nums;
    }

    public static int[] nextLargestNumberToTheRight(int[] nums) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargestNumberToTheRightBruteForce(new int[] {5,2,4,6,1})));
        System.out.println(Arrays.toString(nextLargestNumberToTheRight(new int[] {5,2,4,6,1})));
    }
}
