package ByteByteGo.BitManipulation;

public class LonelyInteger {

    public static int lonelyInteger(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lonelyInteger(new int[] { 1, 3, 3, 2, 1 }));
    }
}
