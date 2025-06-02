package ByteByteGo.BinarySearch;

public class FindTheTargetInARotatedSortedArray {

    public static int findTheTargetInARotatedSortedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] < target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(findTheTargetInARotatedSortedArray(new int[]{8,9,1,2,3,4,5,6,7}, 1));
    }
}
