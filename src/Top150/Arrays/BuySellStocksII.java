package Top150.Arrays;

public class BuySellStocksII {

    public static int buySellStocks(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(buySellStocks(new int[] {7,1,5,3,6,4}));
    }
}
