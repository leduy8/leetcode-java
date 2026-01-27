package src;

public class lc153 {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3,4,5,1,2})); // 1
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2})); // 0
        System.out.println(findMin(new int[] {11,13,15,17})); // 11
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (l <= h) {
            int m = l + (h - l) / 2;
            ans = Math.min(ans, nums[m]);

            // If nums[m] < nums[h] -> right half is sorted -> min on left
            // Else, left half is sorted -> min on right
            if (nums[m] < nums[h]) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
