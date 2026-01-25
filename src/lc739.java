package src;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60}))); // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90}))); // [1,1,0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        // Stack holds the days waiting for the warmer day
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < temperatures.length; i++) {
            // When we see a warmer day, pop out then update the index to res (distant = current index - index of day in stack)
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
