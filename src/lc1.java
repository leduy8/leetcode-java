package src;

import java.util.Arrays;
import java.util.HashMap;

public class lc1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{-1, -2, -3, -4, -5}, -8))); // [2, 4]
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (lookup.containsKey(needed)) {
                return new int[] {lookup.get(needed), i};
            }

            lookup.put(nums[i], i);
        }
        return new int[] {};
    }
}
