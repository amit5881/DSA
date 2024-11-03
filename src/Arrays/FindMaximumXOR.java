package Arrays;

public class FindMaximumXOR {

    public static int findMaximumXOR(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int current = arr[i] ^ arr[j];
                max = Math.max(current, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        System.out.println(findMaximumXOR(new int[]{0}));
    }
}
