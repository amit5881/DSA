package ByteByteGo.DynamicProgramming;

public class NeighbourhoodBurglary {

    public static int neighbourhoodBurglary(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int[] dp = new int[houses.length];
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);
        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 1], houses[i] + dp[i - 2]);
        }
        return dp[houses.length - 1];
    }

    public static int neighbourhoodBurglaryOptimised(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int prevMaxProfit = Math.max(houses[0], houses[1]);
        int prevPrevMaxProfit = houses[0];

        for (int i = 2; i < houses.length; i++) {
            int currentMaxProfit = Math.max(prevMaxProfit, houses[i] + prevPrevMaxProfit);

            prevPrevMaxProfit = prevMaxProfit;
            prevMaxProfit = currentMaxProfit;
        }
        return prevMaxProfit;
    }

    public static void main(String[] args) {
        System.out.println(neighbourhoodBurglary(new int[] {200, 300, 200, 50}));
        System.out.println(neighbourhoodBurglaryOptimised(new int[] {200, 300, 200, 50}));
    }
}
