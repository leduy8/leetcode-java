package src;

import java.util.Arrays;
import java.util.Map;

public class lc322 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {1,2,5}, 11)); // 3 | 11 = 5 + 5 + 1
        System.out.println(coinChange(new int[] {2}, 3)); // -1
        System.out.println(coinChange(new int[] {1}, 0)); // 0
        System.out.println(coinChange(new int[] {2,5,10,1}, 27)); // 4
        System.out.println(coinChange(new int[] {186,419,83,408}, 6249)); // 20
    }

    // Top-down approach (Memoization)
    // Time: O(Coins * Amount)
    // Space: O(Amount)
    public static int coinChangeTopDownDP(int[] coins, int amount) {
        Arrays.sort(coins);
        Map<Integer, Integer> memo = Map.of(0, 0);
        
        
    }
    
    public static int minCoins(int amount) {
        
    }

    // Bottom-up DP approach (Tabular)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[coins.length + 1];

    }
}
