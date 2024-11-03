package CodingMinutes.Arrays;

public class PrintingSubArrays {

    public static void printingSubArrays(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k < j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        printingSubArrays(new int[]{10, 20, 30, 40, 50, 60});
    }
}
