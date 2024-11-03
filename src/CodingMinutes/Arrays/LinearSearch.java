package CodingMinutes.Arrays;

public class LinearSearch {

    public static int linearSearch(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == val) return i;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1,2,3,4}, 3));
    }
}
