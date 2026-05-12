package src.medium;

import java.util.Arrays;

public class lc80 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,1,2,2,3})); // 5
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,1,2,3,3})); // 7
    }

    public static int removeDuplicates(int[] nums) {
        // Use paper and pen to visualize, this is 2 pointer problem
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        System.out.println("Array after remove duplications");
        System.out.println(Arrays.toString(nums));

        return k;
    }
}
