package src.medium;

public class lc1664 {
    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[] {2,1,6,4})); // 1
        System.out.println(waysToMakeFair(new int[] {1,1,1})); // 3
        System.out.println(waysToMakeFair(new int[] {1,2,3})); // 0
    }

    public static int waysToMakeFair(int[] nums) {
        int ways = 0;
        int leftEvens = 0;
        int leftOdds = 0;
        int rightEvens = 0;
        int rightOdds = 0;
        
        // Build initial rightEvens and rightOdds
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                rightEvens += nums[i];
            } else {
                rightOdds += nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                rightEvens -= nums[i];
            } else {
                rightOdds -= nums[i];
            }

            if (leftEvens + rightOdds == leftOdds + rightEvens) {
                ways++;
            }

            if (i % 2 == 0) {
                leftEvens += nums[i];
            } else {
                leftOdds += nums[i];
            }
        }

        return ways;
    }
}
