package src;

import java.util.Arrays;
import java.util.HashMap;

public class lc1365 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8,1,2,2,3}))); // [4,0,1,1,3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{6,5,4,8}))); // [2,1,0,3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7,7,7,7}))); // [0,0,0,0]
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();
        Arrays.sort(copy);

        for (int i = 0; i < copy.length; i++) {
            map.putIfAbsent(copy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            copy[i] = (map.get(nums[i]));
        }

        return copy;
    }
}
