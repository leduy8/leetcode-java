package src;

import java.util.*;

public class lc347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2))); // [1,2]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1))); // [1]
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2))); // [1,2]
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        // Count each occurrence of every number
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // Create a bucket for bucket sort (len + 1 to reduce the "off-by-one" BS)
        List<Integer>[] buckets = new List[nums.length + 1];

        // Fill the bucket
        for (int num: count.keySet()) {
            int freq = count.get(num);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;

        // Loop from end to start of buckets, in each bucket, try to scrape all the data until index == k
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num: buckets[i]) {
                    res[index++] = num;
                    if (index == k) {
                        break;
                    }
                }
            }
        }

        return res;
    }
}
