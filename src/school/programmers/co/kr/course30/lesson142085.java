package src.school.programmers.co.kr.course30;

import java.util.Collections;
import java.util.PriorityQueue;

public class lesson142085 {
    public static void main(String[] args) {
        System.out.println(solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1})); // 5
        System.out.println(solution2(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1})); // 5
        System.out.println(solution(2, 4, new int[] {3, 3, 3, 3})); // 4
        System.out.println(solution2(2, 4, new int[] {3, 3, 3, 3})); // 4
    }

    public static int solution(int n, int k, int[] enemy) {
        // Max Heap approach
        int round = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            n -= e;
            maxHeap.offer(e);
            if (n < 0) {
                if (k == 0) break;
                // Block the biggest damage so far
                n += maxHeap.poll();
                k--;
            }
            round++;
        }

        return round;
    }

    public static int solution2(int n, int k, int[] enemy) {
        // Min Heap approach
        int round = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int e : enemy) {
            minHeap.offer(e);
            // Only accept the smallest damage
            if (minHeap.size() > k) n -= minHeap.poll();
            if (n < 0) break;
            round++;
        }

        return round;
    }
}
