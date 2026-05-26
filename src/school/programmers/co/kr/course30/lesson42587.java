package src.school.programmers.co.kr.course30;

import java.util.ArrayDeque;
import java.util.Deque;

public class lesson42587 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0)); // 5
    }

    public static int solution(int[] priorities, int location) {
        int count = 0;

        // Make priorities with index as queue
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {priorities[i], i});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean hasHigher = false;

            // Find higher
            for (int[] q: queue) {
                if (cur[0] < q[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(cur); // Move item to end of queue
            } else {
                count++; // Process
                if (cur[1] == location) {
                    return count;
                }
            }
        }

        return count;
    }
}
