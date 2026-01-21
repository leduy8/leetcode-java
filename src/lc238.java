package src;

import java.util.Arrays;

public class lc238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4}))); // [24,12,8,6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0,0,9,0,0]
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        // Prefix = Product of all number before i
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Suffix = Product of all number after i
        for (int i = n - 1 - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // At i, prefix[i] * suffix[i] = Product of before i * Product of after i
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * suffix[i];
        }

        return res;
    }
}
