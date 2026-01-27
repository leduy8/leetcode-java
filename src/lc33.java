package src;

public class lc33 {
    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(search(new int[] {1}, 0)); // -1
        System.out.println(search(new int[] {1,3}, 3)); // 1
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (nums[m] == target) return m;

            // Check if left part is sorted
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1; // move left
                } else {
                    l = m + 1; // move right
                }
            }
            // Right part is sorted
            else {
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1; // move right
                } else {
                    r = m - 1; // move left
                }
            }
        }

        return -1;
    }
}
