package src.easy;

import java.util.Arrays;

public class lc2574 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRightDifference(new int[]{10, 4, 8, 3}))); // [15, 1, 6, 9]
        System.out.println(Arrays.toString(leftRightDifference(new int[]{1}))); // [0]
    }

    public static int[] leftRightDifference(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        int[] res = new int[len];
        int tmp;

        tmp = nums[0];
        for (int i = 1; i < len; i++) {
            leftSum[i] = tmp;
            tmp += nums[i];
        }

        tmp = nums[len - 1];
        for (int i = len - 1 - 1; i >= 0; i--) {
            rightSum[i] = tmp;
            tmp += nums[i];
        }

        for (int i = 0; i < len; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i]);
        }

        return res;
    }
}
