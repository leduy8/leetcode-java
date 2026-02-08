package src;

import java.util.Arrays;

public class lc322 {
    public static void main(String[] args) {
        System.out.println(coinChangeTopDownDP(new int[] {1,2,5}, 11)); // 3 | 11 = 5 + 5 + 1
        System.out.println(coinChangeTopDownDP(new int[] {2}, 3)); // -1
        System.out.println(coinChangeTopDownDP(new int[] {1}, 0)); // 0
        System.out.println(coinChangeTopDownDP(new int[] {2,5,10,1}, 27)); // 4
        System.out.println(coinChangeTopDownDP(new int[] {186,419,83,408}, 6249)); // 20

        System.out.println(coinChangeBottomUpDP(new int[] {1,2,5}, 11)); // 3 | 11 = 5 + 5 + 1
        System.out.println(coinChangeBottomUpDP(new int[] {2}, 3)); // -1
        System.out.println(coinChangeBottomUpDP(new int[] {1}, 0)); // 0
        System.out.println(coinChangeBottomUpDP(new int[] {2,5,10,1}, 27)); // 4
        System.out.println(coinChangeBottomUpDP(new int[] {186,419,83,408}, 6249)); // 20
    }

    // Top-down approach (Memoization)
    // Time: O(Coins * Amount)
    // Space: O(Amount)
    private static int[] memo;

    public static int coinChangeTopDownDP(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 0 means "uncomputed"; we store -1 for impossible
        return dp(coins, amount);
    }

    private static int dp(int[] coins, int remains) {
        if (remains == 0) return 0;
        if (remains < 0) return -1;

        if (memo[remains] != 0) {
            return memo[remains];
        }

        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dp(coins, remains - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }

        memo[remains] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[remains];
    }

    // Bottom-up DP approach (Tabulation)
    // Time: O(Coins * Amount)
    // Space: O(Amount)
    public static int coinChangeBottomUpDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Use a large sentinel value instead of Integer.MAX_VALUE to avoid overflow when adding 1
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
