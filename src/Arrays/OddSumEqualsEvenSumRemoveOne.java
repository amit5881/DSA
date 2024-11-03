package Arrays;

public class OddSumEqualsEvenSumRemoveOne {

    public static int findElementToRemove(int[] arr) {
        int totalOddSum = 0, totalEvenSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                totalEvenSum += arr[i];
            } else {
                totalOddSum += arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (totalEvenSum == totalOddSum) {
                return -1;
            } else if (totalEvenSum > totalOddSum) {
                totalEvenSum -= arr[i];
                if (totalEvenSum == totalOddSum) {
                    return arr[i];
                } else {
                    totalEvenSum += arr[i];
                }
            } else {
                totalOddSum -= arr[i];
                if (totalOddSum == totalEvenSum) {
                    return arr[i];
                } else {
                    totalOddSum += arr[i];
                }
            }
        }

        // Return -1 if no element can be removed to meet the condition
        return -1;
    }

    public static void main(String[] args) {
        int result = findElementToRemove(new int[]{2,4,6,3,4});
        System.out.println(result);
    }
}
