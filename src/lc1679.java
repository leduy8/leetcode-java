package src;

import java.util.Arrays;

public class lc1679 {
    public static void main(String[] args) {
        System.out.println(maxOperations(new int[] {1,2,3,4}, 5)); // 2
        System.out.println(maxOperations(new int[] {3,1,3,4,3}, 6)); // 1
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int res = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                res++;
                left++;
                right--;
            }
            else if (sum > k) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
