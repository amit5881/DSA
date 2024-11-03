package CodingMinutes.DivideAndConquer;

public class BinarySearchUsingRecursion {

    public static int binarySearch(int[] arr, int element) {
        return search(arr, 0, arr.length - 1, element);
    }

    public static int search(int[] arr, int start, int end, int element) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) return mid;
            if (arr[mid] > element) return search(arr, start, mid - 1, element);
            return search(arr, mid + 1, end, element);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(binarySearch(arr, 4));
    }
}
