package CodingMinutes.Arrays;

public class PrintingPairs {

    public static void printPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + " " + arr[j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPairs(new int[]{10,20,30,40,50});
    }
}
