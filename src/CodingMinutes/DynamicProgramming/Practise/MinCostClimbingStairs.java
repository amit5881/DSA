package CodingMinutes.DynamicProgramming.Practise;

public class MinCostClimbingStairs {

    public static int minCostClimbingCost(int[] costs) {
        int[] minCostDp = new int[costs.length + 1];
        minCostDp[0] = 0;
        minCostDp[1] = 0;
        for (int i = 2; i <= costs.length; i++)
            minCostDp[i] = Math.min(costs[i - 1] + minCostDp[i - 1], costs[i - 2] + minCostDp[i - 2]);
        return minCostDp[costs.length];
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
