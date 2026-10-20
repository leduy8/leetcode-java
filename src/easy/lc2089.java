package src.easy;

import java.util.ArrayList;
import java.util.List;

public class lc2089 {
    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1,2,5,2,3}, 2)); // [1,2]
        System.out.println(targetIndices(new int[]{1,2,5,2,3}, 3)); // [3]
        System.out.println(targetIndices(new int[]{1,2,5,2,3}, 5)); // [4]
    }

    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int less = 0;
        int equal = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) less++;
            else if (nums[i] == target) equal++;
        }

        for (int i = 0; i < equal; i++) {
            list.add(less + i);
        }

        return list;
    }
}
