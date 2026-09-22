package src.medium;

public class lc413 {
    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4})); // 3
        System.out.println(numberOfArithmeticSlices(new int[]{1})); // 0
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int n = nums.length;
        int streak = 0;

        if (nums == null || n < 3) {
            return 0;
        }

        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                streak++;
                res += streak;
            } else {
                streak = 0;
            }
        }

        return res;
    }
}
