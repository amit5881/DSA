package Restart_CrackingTheCodingInterviewBook.FastAndSlowPointers;

public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        int fast = n, slow = n;
        while (true) {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
            if (fast == 1) return true;
            else if (slow == fast) return false;
        }
    }

    private static int getNextNumber(int x) {
        int nextNum = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            nextNum += digit * digit;
        }
        return nextNum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(23));
        System.out.println(isHappyNumber(116));
    }
}
