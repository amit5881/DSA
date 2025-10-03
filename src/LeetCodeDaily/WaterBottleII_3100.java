package LeetCodeDaily;

public class WaterBottleII_3100 {

    public static int waterBottle(int numBottles, int numExchange) {
        int ans = 0;
        int empty = 0;

        while (numBottles > 0) {
            ans += numBottles;
            empty += numBottles;

            numBottles = 0;

            if (empty >= numExchange) {
                numBottles = 1;
                empty -= numExchange;
            }
            numExchange++;
        }
        return ans;
    }

    public static int waterBottlesOptimised(int numBottles, int numExchange) {
        double n = numBottles;
        double e = numExchange;

        double b = 2 * e - 3;
        double rootVal = b * b + 8 * (n - 1);

        double root = (-b + Math.sqrt((double) rootVal)) / 2.0;

        double t = (long) Math.floor(root);

        if (t > 0 && t * t + (2 * e - 3) + t + 2 > 2 * n) {
            t--;
        }
        return (int) (numBottles + t);
    }

    public static void main(String[] args) {
        System.out.println(waterBottlesOptimised(13, 6));
        System.out.println(waterBottlesOptimised(10, 3));
    }
}
