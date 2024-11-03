package Arrays;

public class SearchInRotatedSortedArray {

    public static int searchInRotatedArray(int[] arr, int target) {
        if (arr.length == 1 && arr[0] == target) return 0;

        int pivotIndex = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                pivotIndex = i;
            }
        }

        int resultIndex;
        resultIndex = binarySearchInRotatedArray(arr, 0, pivotIndex, target);
        if (resultIndex < 0) resultIndex = binarySearchInRotatedArray(arr, pivotIndex, arr.length - 1, target);
        return resultIndex;
    }

    private static int binarySearchInRotatedArray(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
//        System.out.println(searchInRotatedArray(new int[] {4,5,6,7,0,1,2}, 0));
//        System.out.println(searchInRotatedArray(new int[] {4,5,6,7,0,1,2}, 3));
//        System.out.println(searchInRotatedArray(new int[] {1}, 0));
        System.out.println(searchInRotatedArray(new int[] {1,3}, 3));
    }
}
