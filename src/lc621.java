package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class lc621 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] {'A','A','A','B','B','B'}, 2)); // 8
        System.out.println(leastInterval(new char[] {'A','C','A','B','D','B'}, 1)); // 6
        System.out.println(leastInterval(new char[] {'A','A','A','B','B','B'}, 3)); // 10
        System.out.println(leastInterval(new char[] {'A','A','A','B','B'}, 3)); // 9
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq) {
            if(f > 0) {
                maxHeap.add(f);
            }
        }

        int count = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1; // Because after running a task, we must wait n time before running it again.
            int workDone = 0; // How many tasks are able to schedule in each cycle

            for(int i = 0; i < cycle; i++) {
                if(!maxHeap.isEmpty()) {
                    int curr = maxHeap.poll(); // Take the most frequent task
                    if (curr - 1 > 0) {
                        temp.add(curr - 1); // It still has remaining occurrences
                    }
                    workDone++; // Work done of a task in this cycle
                }
            }

            maxHeap.addAll(temp);
            count += maxHeap.isEmpty() ? workDone : cycle;
        }

        return count;
    }
}