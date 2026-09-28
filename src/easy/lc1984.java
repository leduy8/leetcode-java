package src.easy;

import java.util.Arrays;

public class lc1984 {
    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] {90}, 1)); // 0
        System.out.println(minimumDifference(new int[] {9, 4, 1, 7}, 2)); // 2
        System.out.println(minimumDifference(new int[] {87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6)); // 74560
    }

    public static int minimumDifference(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - k; i++) {
            minDiff = Math.min(minDiff, nums[i + k - 1] - nums[i]);
        }

        return minDiff;
    }
}
