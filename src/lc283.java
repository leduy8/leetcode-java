package src;

import java.util.Arrays;

public class lc283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12}); // [1,3,12,0,0]
        moveZeroes(new int[]{0}); // [0]
    }

    public static void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        
        for (int i = insertPos; i < nums.length; i++) {
            nums[insertPos++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
