package src.medium;

public class lc3864 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {0,2,1})); // 2
        System.out.println(minOperations(new int[] {1,0,2})); // 2
        System.out.println(minOperations(new int[] {2,0,1,3})); // -1
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        // Find starting point (index of 0)
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                start = i;
                break;
            }
        }

        boolean asc = true;
        boolean desc = true;
        // 1 -> n - 1 (Use index 0 as anchor)
        for (int i = 1; i < n; i++) {
            int val = nums[(start + i) % n];
            if (val != i) {
                asc = false;
            }
            if (val != n - i) {
                desc = false;
            }
            if (!asc && !desc) {
                return -1;
            }
        }

        // Either rotate 0 to start or flip -> rotate -> flip
        if (asc) {
            return Math.min(start, 1 + n - start + 1);
        }

        // Either flip -> rotate or flip -> rotate -> flip
        return Math.min(1 + (n - 1) - start, 1 + start + 1);
    }
}