package CodingMinutes.DivideAndConquer;

public class RotateArraySearch {

    public static int rotateArraySearch(int[] arr, int element) {
        int pivotIndex = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                pivotIndex = i + 1;
            }
        }

        if (arr[pivotIndex] > element) {
            return binarySearchSelf(arr, 0, pivotIndex - 1, element);
        } else {
            return binarySearchSelf(arr, pivotIndex, arr.length, element);
        }
    }

    public static int binarySearchSelf(int[] arr, int start, int end, int element) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] > element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(rotateArraySearch(new int[]{7,9,10,1,2,3,4,5,6}, 4));
    }
}
