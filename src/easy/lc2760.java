package src.easy;

public class lc2760 {
    public static void main(String[] args) {
        System.out.println(longestAlternatingSubarray(new int[] {3,2,5,4}, 5)); // 3
        System.out.println(longestAlternatingSubarray(new int[] {1,2}, 2)); // 1
        System.out.println(longestAlternatingSubarray(new int[] {2,3,4,5}, 4)); // 3
    }

    // Sliding Window
    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                l = i;
                r = i;

                while (r < n) {
                    if (nums[r] > threshold) break;
                    if (isValidPosAndVal(r - l, nums[r])) r++;
                    else break;
                }
                max = Math.max(max, r - l);
                i = r - 1;
            }
        }

        return max;
    }

    public static boolean isValidPosAndVal(int curLen, int curVal) {
        return (curLen % 2 == 0 && curVal % 2 == 0) 
                || (curLen % 2 != 0 && curVal % 2 != 0);
    }

    // Array
    // public static int longestAlternatingSubarray(int[] nums, int threshold) {
    //     int n = nums.length;
    //     int chain = (nums[0] % 2 == 0 && nums[0] <= threshold) ? 1 : 0;
    //     int max = chain;

    //     for (int i = 1; i < n; i++) {
    //         if (nums[i] > threshold) {
    //             chain = 0;
    //         } else if (nums[i] % 2 == 0) {
    //             if (nums[i - 1] % 2 == 0) chain = 0;
    //             chain++;
    //         } else if (nums[i] % 2 != 0 && chain > 0) {
    //             if (nums[i - 1] % 2 != 0) chain = -1;
    //             chain++;
    //         }
    //         max = Math.max(chain, max);
    //     }

    //     return max;
    // }
}
