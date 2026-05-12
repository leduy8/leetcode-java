package src.medium;

import java.util.Arrays;

public class lc34 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 8))); // [3,4]
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6))); // [-1,-1]
        System.out.println(Arrays.toString(searchRange(new int[] {}, 0))); // [-1,-1]
    }

    public static int[] searchRange(int[] nums, int target) {
        int found1 = binarySearch(nums, target, true);
        int found2 = binarySearch(nums, target, false);

        return new int[] {found1, found2};
    }

    public static int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int l = 0;
        int r = nums.length - 1;
        int idx = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            }
            else if (nums[m] > target) {
                r = m - 1;
            } else {
                // Found index
                idx = m;
                // If searching left, move r to left of i to see if we find any target number in the left
                // If searching right, move l to right of i to see if we find any target number in the right
                if (isSearchingLeft) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return idx;
    }
}
