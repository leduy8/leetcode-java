package src.medium;

public class lc1493 {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,1,0,1})); // 3
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1})); // 5
    }

    public static int longestSubarray(int[] nums) {
        int zeroCnt = 0;
        int res = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            zeroCnt += nums[r] == 0 ? 1 : 0;
            
            while (zeroCnt > 1) {
                if (nums[l] == 0) {
                    zeroCnt--;
                }
                l++;
            }

            res = Math.max(res, r - l);
        }

        return res;
    }
}