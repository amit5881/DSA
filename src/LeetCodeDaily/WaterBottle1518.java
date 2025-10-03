package LeetCodeDaily;

public class WaterBottle1518 {

    public static int waterBottle(int filled, int exchange) {
        int ans = 0;
        int empty = 0;
        while (filled > 0) {
            ans += filled;
            empty += filled;

            filled = empty / exchange;
            empty = empty % exchange;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(waterBottle(9, 3));
        System.out.println(waterBottle(15, 4));
        System.out.println(waterBottle(12, 4));
    }
}
