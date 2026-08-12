package Restart_CrackingTheCodingInterviewBook.BinarySearch.PartiallySortedArrays;

public class FindTheTargetInARotatedSortedArray {

    public static int solution(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (arr[mid] < target && target <= arr[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return (arr.length > 0 && arr[left] == target) ? left : -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{8,9,1,2,3,4,5,6,7}, 1));
    }
}
