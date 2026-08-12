package Restart_CrackingTheCodingInterviewBook.BinarySearch.NonIntuitiveSearchSpace;

public class LocalMaxima {

    public static int localMaxima(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(localMaxima(new int[]{1, 4, 3, 2, 3}));
    }
}
