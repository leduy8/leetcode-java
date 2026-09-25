package src.medium;

// import java.util.HashMap;
// import java.util.Map;

public class lc1658 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {1, 1, 4, 2, 3}, 5)); // 2
        System.out.println(minOperations(new int[] {5, 6, 7, 8, 9}, 4)); // -1
        System.out.println(minOperations(new int[] {3, 2, 20, 1, 1, 3}, 10)); // 5
    }

    // Sliding window
    public static int minOperations(int[] nums, int x) {
        int target = sum(nums) - x;
        int maxWindow = -1;
        int curSum = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];

            while (l <= r && curSum > target) {
                curSum -= nums[l++];
            }

            if (curSum == target) {
                maxWindow = Math.max(maxWindow, r - l + 1); // "+ 1" for operation count
            }
        }

        return maxWindow == -1 ? -1 : nums.length - maxWindow;
    }

    public static int sum(int[] arr) {
        int s = 0;
        for (int i : arr) {
            s += i;
        }
        return s;
    }

    // Hash Table + Prefix Sum
    // public static int minOperations(int[] nums, int x) {
    //     int minOps = Integer.MAX_VALUE;
    //     int n = nums.length;
    //     int[] prefixSum = new int[n];
    //     Map<Integer, Integer> prefixMap = new HashMap<>();

    //     int sum = 0;
    //     for (int i = 0; i < n; i++) {
    //         sum += nums[i];
    //         prefixSum[i] = sum;
    //         if (prefixSum[i] == x) {
    //             minOps = Math.min(minOps, i + 1);
    //         }
    //         prefixMap.put(prefixSum[i], i);
    //     }

    //     sum = 0;
    //     for (int i = n - 1; i >= 0; i--) {
    //         sum += nums[i];
    //         if (sum == x) {
    //             minOps = Math.min(minOps, n - i);
    //         }
    //         int idx = prefixMap.getOrDefault(x - sum, -1);
    //         // Ensure valid prefix match and no overlap (prefix ends before suffix starts)
    //         if (idx != -1 && idx < i) {
    //             int prefixOps = idx + 1;
    //             int suffixOps = n - i;
    //             minOps = Math.min(minOps, prefixOps + suffixOps);
    //         }
            
    //     }

    //     return minOps != Integer.MAX_VALUE ? minOps : -1;
    // }
}