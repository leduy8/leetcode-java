package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4})); // [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[] {0,1,1})); // []
        System.out.println(threeSum(new int[] {0,0,0})); // [[0,0,0]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            
            if (i > 0 && cur == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int threeSum = cur + nums[left] + nums[right]; 
                if (threeSum > 0) {
                    right--;
                } else if (threeSum < 0) {
                    left++;
                } else {
                    res.add(List.of(cur, nums[left], nums[right]));
                    do {
                        left++;
                    } while (nums[left] == nums[left - 1] && left < right);
                }
            }
        }
        return res;
    }
}
