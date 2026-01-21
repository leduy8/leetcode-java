package src;

import java.util.Arrays;

public class lc26 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,1,2})); // 2, nums = [1,2,_]
        System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4})); // 5, nums = [0,1,2,3,4,_,_,_,_,_]
    }

    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int index = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
                k++;
            }
        }

        System.out.println(Arrays.toString(nums));
        return k;
    }
}
