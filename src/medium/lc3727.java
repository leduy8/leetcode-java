package src.medium;

import java.util.Arrays;

public class lc3727 {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[] {1,2,3})); // 12
        System.out.println(maxAlternatingSum(new int[] {1,-1,2,-2,3,-3})); // 16
    }

    public static  long maxAlternatingSum(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        for (int i = 0; i < n / 2; i++) {
            sum -= nums[i];
        }

        for (int i = n / 2; i < n; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
