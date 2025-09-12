package src;

public class lc643 {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4)); // 12.75000
        System.out.println(findMaxAverage(new int[]{5}, 1)); // 5.00000
    }

    public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        
        // Find first window size
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int maxSum = sum;
        
        // Sliding window till the end
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        
        return (double) maxSum / k;
    }
}