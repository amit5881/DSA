package ByteByteGo.FastAndSlowPointers;

public class HappyNumber {

    public static boolean isHappyNumber(int x) {
        int slow = x;
        int fast = x;

        while (true) {
            slow = getNextNum(slow);
            fast = getNextNum(getNextNum(fast));

            if (fast == 1) {
                return true;
            } else if (slow == fast){
                return false;
            }
        }
    }

    private static int getNextNum(int x) {
        int nextNum = 0;
        while (x > 0) {
            int digit = x % 10;
            x = x / 10;
            nextNum += (int) Math.pow(digit, 2);
        }
        return nextNum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println(isHappyNumber(116));
    }
}
