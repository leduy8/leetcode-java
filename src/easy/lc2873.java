package src.easy;

public class lc2873 {
    public static void main(String[] args) {
        System.out.println(maximumTripletValue(new int[] {12,6,1,2,7})); // 17
        System.out.println(maximumTripletValue(new int[] {1,10,3,4,19})); // 133
        System.out.println(maximumTripletValue(new int[] {1,2,3})); // 0
    }

    // Prefix Sum
    public static long maximumTripletValue(int[] nums) {
        long max = 0;
        int n = nums.length;
        int j = 1;

        while (j < n - 1) {
            int curMaxOfI = 0;
            int curMaxOfK = 0;
            // Find largest nums[i] (i before j)
            for (int i = 0; i < j; i++) {
                curMaxOfI = Math.max(curMaxOfI, nums[i]);
            }

            // Find largest nums[k] (k after j)
            for (int i = j + 1; i < n; i++) {
                curMaxOfK = Math.max(curMaxOfK, nums[i]);
            }

            max = Math.max(max, (long) (curMaxOfI - nums[j]) * curMaxOfK);

            j++;
        }

        return max;
    }

    // Brute Force
    // public static long maximumTripletValue(int[] nums) {
    //     long max = 0;
    //     int n = nums.length;
        
    //     for (int i = 0; i < n - 2; i++) {
    //         for (int j = i + 1; j < n - 1; j++) {
    //             int curSubtract = nums[i] - nums[j];
    //             if (curSubtract < 0) continue;
    //             for (int k = j + 1; k < n; k++) {
    //                 long cur = (long) curSubtract * nums[k];
    //                 max = Math.max(max, cur);
    //             }
    //         }
    //     }

    //     return max;
    // }
}
