package src;

import java.util.Arrays;

public class lc213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,3,2})); // 3
        System.out.println(rob(new int[] {1,2,3,1})); // 4
        System.out.println(rob(new int[] {1,2,3})); // 3
    }

    public static int rob(int[] nums) {
        int start = 0;
        int end = nums.length;

        // Find max profit exclude the first house
        int a = helper(Arrays.copyOfRange(nums, start + 1, end));
        // Find max profit exclude the last house
        int b = helper(Arrays.copyOfRange(nums, start, end -1));
        
        // Find the better profit, also check with nums[0] for case only 1 house
        return Math.max(nums[0], Math.max(a, b));
    }
    
    public static int helper(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // [rob1, rob2, n, n+1, ...]
        for (int n: nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
