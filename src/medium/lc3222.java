package src.medium;

public class lc3222 {
    public static void main(String[] args) {
        System.out.println(minSumSquareDiff(new int[] {1,2,3,4}, new int[] {2,10,20,19}, 0, 0)); // 579
        System.out.println(minSumSquareDiff(new int[] {1,4,10,12}, new int[] {5,8,6,9}, 1, 1)); // 43
    }

    // Array & Counting Sort & Greedy
    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) (k1 + k2);
        int n = nums1.length;
        int[] diffs = new int[n];
        int max = 0;

        // Populate diffs array
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            if (diffs[i] > max) max = diffs[i];
        }

        // Fill freq array
        long[] freq = new long[max + 1];
        for (int d : diffs) {
            freq[d]++;
        }

        // Move freq by bulk and modify k
        for (int i = max; i > 0; i--) {
            if (freq[i] == 0) continue;

            long tmp = Math.min(freq[i], k);
            freq[i] -= tmp;
            freq[i - 1] += tmp;
            k -= tmp;
        }

        // Calc sum
        long sum = 0L;
        for (int i = 0; i <= max; i++) {
            sum += freq[i] * (long) i * i;
        }

        return sum;
    }
}
