package src;

// Ref: https://youtu.be/cTBiBSnjO3c?si=s9ezFMuu_KSdx1sN

import java.util.Arrays;
import java.util.Stack;

public class lc739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); // [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60}))); // [1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90}))); // [1,1,0]
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> pairs = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];

            while (!pairs.isEmpty() && t > pairs.peek()[0]) {
                int[] pair = pairs.pop();
                result[pair[1]] = i - pair[1];
            }

            pairs.push(new int[]{t, i});
        }

        return result;
    }
}
