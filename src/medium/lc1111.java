package src.medium;

import java.util.Arrays;
// import java.util.Deque;
// import java.util.ArrayDeque;

public class lc1111 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxDepthAfterSplit("(()())"))); // [0,1,1,1,1,0]
        System.out.println(Arrays.toString(maxDepthAfterSplit("()(())()"))); // [0,0,0,1,1,0,1,1]
    }

    // Stack
    // public static int[] maxDepthAfterSplit(String seq) {
    //     int n = seq.length();
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     int[] res = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         char c = seq.charAt(i);
    //         if (c == '(') {
    //             int group = stack.size() % 2;
    //             res[i] = group;
    //             stack.push(group);
    //         } else if (c == ')') {
    //             int group = stack.pop();
    //             res[i] = group;
    //         }
    //     }

    //     return res;
    // }

    // Without Stack
    public static int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                int group = depth % 2;
                res[i] = group;
                depth++;
            } else if (c == ')') {
                depth--;
                int group = depth % 2;
                res[i] = group;
            }
        }

        return res;
    }
}
