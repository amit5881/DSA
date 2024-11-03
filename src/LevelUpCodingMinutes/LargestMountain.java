package LevelUpCodingMinutes;

public class LargestMountain {

    public static int largestMountain(int[] arr) {
        int largest = 0;
        for (int i = 1; i < arr.length - 1;) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int count = 1;
                int j = i;
                while (j >= 1 && arr[j] > arr[j - 1]) {
                    j--;
                    count++;
                }
                while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    i++;
                    count++;
                }
                largest = Math.max(largest, count);
            } else {
                i++;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(largestMountain(new int[] {5,6,1,2,3,4,5,4,3,2,0,1,2,3,-2,4}));
    }
}
