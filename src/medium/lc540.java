package src.medium;

public class lc540 {
    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8})); // 2
        System.out.println(singleNonDuplicate(new int[] {3,3,7,7,10,11,11})); // 10
        System.out.println(singleNonDuplicate(new int[] {1,1,2})); // 2
        System.out.println(singleNonDuplicate(new int[] {1})); // 1
    }

    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l) / 2;
            m = m % 2 != 0 ? m - 1 : m; // force m even
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                r = m;
            }
        }

        return nums[l];
    }
}
