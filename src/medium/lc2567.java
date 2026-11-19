package src.medium;

import java.util.Arrays;

public class lc2567 {
    public static void main(String[] args) {
        System.out.println(minimizeSum(new int[]{1, 4, 7, 8, 5})); // 3
        System.out.println(minimizeSum(new int[]{1, 4, 3})); // 0
    }

    public static int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if (n <= 3) return 0;
        
        int n1 = Math.abs(nums[n - 3] - nums[0]);
        int n2 = Math.abs(nums[n - 2] - nums[1]);
        int n3 = Math.abs(nums[n - 1] - nums[2]);

        return Math.min(Math.min(n1, n2), n3);
    }
}
