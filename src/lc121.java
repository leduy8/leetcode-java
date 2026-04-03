package src;

public class lc121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4})); // 5
        System.out.println(maxProfit(new int[] {7,6,4,3,1})); // 0
        System.out.println(maxProfit(new int[] {2,4,1})); // 2
    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            profit = Math.max(prices[i] - buyPrice, profit);
        }
        
        return profit;
    }
}
