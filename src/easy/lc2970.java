package src.easy;

public class lc2970 {
    public static void main(String[] args) {
        System.out.println(incremovableSubarrayCount(new int[] {1,2,3,4})); // 10
        System.out.println(incremovableSubarrayCount(new int[] {6,5,7,8})); // 7
        System.out.println(incremovableSubarrayCount(new int[] {8,7,6,6})); // 3
    }

    public static int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isIncremovable(nums, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isIncremovable(int[] nums, int start, int end) {
        int lastVal = -1;

        for (int k = 0; k < nums.length; k++) {
            // If k in the removed array
            if (start <= k && k <= end) {
                continue;
            }

            // If found a non-increamenting number
            if (nums[k] <= lastVal) {
                return false;
            }

            lastVal = nums[k];
        }

        return true; // Subarray is all increamenting
    }
}
