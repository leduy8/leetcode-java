package src.easy;

public class lc3095 {
    public static void main(String[] args) {
        System.out.println(minimumSubarrayLength(new int[] {1,2,3}, 2)); // 1
        System.out.println(minimumSubarrayLength(new int[] {2,1,8}, 10)); // 3
        System.out.println(minimumSubarrayLength(new int[] {1,2}, 0)); // 1
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int currentOr = 0;
            for (int j = i; j < nums.length; j++) {
                currentOr |= nums[j];
                if (currentOr >= k) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
