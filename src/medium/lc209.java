package src.medium;

public class lc209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3})); // 2
        System.out.println(minSubArrayLen(4, new int[] {1,4,4})); // 1
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1})); // 0
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int cur = 0;

        for (int r = 0; r < n; r++) {
            cur += nums[r];
            if (cur >= target) {
                while (cur >= target) {
                    min = Math.min(min, r - l + 1);
                    cur -= nums[l];
                    l++;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }

        return min = Math.min(min, n - l + 1);
    }
}
