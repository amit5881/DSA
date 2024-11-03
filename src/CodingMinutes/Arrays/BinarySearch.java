package CodingMinutes.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] arr, int val) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
       return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,7}, 3));
    }
}
