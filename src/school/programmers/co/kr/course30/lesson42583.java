package src.school.programmers.co.kr.course30;

import java.util.ArrayDeque;
import java.util.Deque;

public class lesson42583 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7,4,5,6})); // 8
        System.out.println(solution(100, 100, new int[] {10})); // 101
        System.out.println(solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10})); // 110
    }
    
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curTruck = 0;
        int curWeight = 0;

        // Init bridge (queue)
        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        while (curTruck < truck_weights.length || curWeight > 0) {
            time++;
            curWeight -= bridge.poll();
            
            // Check if can add more truck
            if (curTruck < truck_weights.length) {
                // Check weight
                if (curWeight + truck_weights[curTruck] <= weight) {
                    bridge.offer(truck_weights[curTruck]);
                    curWeight += truck_weights[curTruck];
                    curTruck++;
                } else {
                    bridge.offer(0); // Truck moves, add empty space
                }
            } else {
                bridge.offer(0); // // Truck moves, add empty space
            }
        }

        return time;
    }
}
