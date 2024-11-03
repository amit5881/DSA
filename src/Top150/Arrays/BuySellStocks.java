package Top150.Arrays;

public class BuySellStocks {

    public static int buySellStocks(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int tempProfit = prices[j] - prices[i];
                if (profit < tempProfit) {
                    profit = tempProfit;
                }
            }
        }
        return profit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
