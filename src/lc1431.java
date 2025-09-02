package src;

import java.util.ArrayList;
import java.util.List;

public class lc1431 {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3)); // [true,true,true,false,true]
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2}, 1)); // [true,false,false,false,false]
        System.out.println(kidsWithCandies(new int[]{12,1,12}, 10)); // [true,false,true]
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = findMax(candies);
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (max < j) max = j;
        }
        return max;
    }
}
