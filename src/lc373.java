package src;

import java.util.*;

public class lc373 {
    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[] {1,7,11}, new int[] {2,4,6}, 3)); // [[1,2],[1,4],[1,6]]
        System.out.println(kSmallestPairs(new int[] {1,1,2}, new int[] {1,2,3}, 2)); // [[1,1],[1,1]]
        System.out.println(kSmallestPairs(new int[] {1,2,4,5,6}, new int[] {3,5,7,9}, 3)); // [[1,3],[2,3],[1,5]]
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // Priority queue to store pairs with the smallest sums, sorted by the sum
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        // Push the initial pairs into the priority queue
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            heap.offer(new int[] {nums1[i] + nums2[0], 0}); // The sum and the index of the second element in nums2
        }

        // Pop the k smallest pairs from the priority queue
        while (k > 0 && !heap.isEmpty()) {
            int[] pair = heap.poll();
            int sum = pair[0]; // Get the smallest sum
            int pos = pair[1]; // Get the index of the second element in nums2

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            res.add(currentPair); // Add the pair to the result list

            // If there are more elements in nums2, push the next pair into the priority queue
            if (pos + 1 < nums2.length) {
                heap.offer(new int[] {sum - nums2[pos] + nums2[pos + 1], pos + 1});
            }

            k--; // Decrement k
        }

        return res; // Return the k smallest pairs
    }
}
