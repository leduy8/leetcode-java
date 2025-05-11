package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1365 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8,1,2,2,3}))); // [4,0,1,1,3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{6,5,4,8}))); // [2,1,0,3]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7,7,7,7}))); // [0,0,0,0]
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int n : nums) {
            int count = 0;
            for (int n2 : nums) {
                if (n2 < n) {
                    count++;
                }
            }
            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
