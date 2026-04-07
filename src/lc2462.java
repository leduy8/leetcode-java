package src;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class lc2462 {
    public static void main(String[] args) {
        System.out.println(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4)); // 11
        System.out.println(totalCost(new int[]{1, 2, 4, 1}, 3, 3)); // 4
    }

    public static long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int t1 = !pq1.isEmpty() ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = !pq2.isEmpty() ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                res += t1;
                pq1.poll();
            } else {
                res += t2;
                pq2.poll();
            }
        }
        return res;
    }
}