package src.school.programmers.co.kr.course30;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class lesson42628 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // [0,0]
        System.out.println(Arrays.toString(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // [333, -45]
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String s: operations) {
            String[] temp = s.split(" ");
            String ops = temp[0];
            int num = Integer.parseInt(temp[1]);
            if (ops.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if (ops.equals("D")) {
                if (num == 1 && !minHeap.isEmpty()) {
                    int max = maxHeap.poll();
                    minHeap.remove(max);
                } else if (num == -1 && !minHeap.isEmpty()) {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }

        return !minHeap.isEmpty() ? new int[] {maxHeap.poll(), minHeap.poll()} : new int[] {0,0};
    }
}
