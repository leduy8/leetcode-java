package src;

import java.util.Collections;
import java.util.PriorityQueue;

public class lc1046 {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[] {2,7,4,1,8,1})); // 1
        System.out.println(lastStoneWeight(new int[] {1})); // 1
    }

    public static int lastStoneWeight(int[] stones) {
        // Create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int s: stones) {
            maxHeap.add(s);
        }
        
        // Smash stones
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            
            if (first != second) {
                maxHeap.add(first - second);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
