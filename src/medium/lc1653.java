package src.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc1653 {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab")); // 2
        System.out.println(minimumDeletions("bbaaaaabb")); // 2
    }

    // Stack
    public static int minimumDeletions(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int deletions = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a' && !stack.isEmpty() && stack.peek() == 'b') {
                stack.poll();
                deletions++;
            } else {
                stack.push(c);
            }
        }

        return deletions;
    }

    // Prefix Sum
    // public static int minimumDeletions(String s) {
    //     int n = s.length();
    //     int deletions = n;
    //     int cntA = 0;
    //     int cntB = 0;

    //     for (char c : s.toCharArray()) {
    //         if (c == 'a') cntA++;
    //     }

    //     for (char c : s.toCharArray()) {
    //         if (c == 'a') cntA--;
    //         deletions = Math.min(deletions, cntA + cntB);
    //         if (c == 'b') cntB++;
    //     }

    //     return deletions;
    // }

    // String
    // public static int minimumDeletions(String s) {
    //     int res = Integer.MAX_VALUE;
    //     int n = s.length();
    //     int numA = 0;
    //     int numB = 0;
    //     int curA = 0;
    //     int curB = 0;

    //     if (n == 1) return 0;

    //     for (int i = 0; i < n; i++) {
    //         char c = s.charAt(i);
    //         if (c == 'a') numA++;
    //         else if (c == 'b') numB++;
    //     }

    //     if (numA == 0 || numB == 0) return 0;

    //     if (s.charAt(0) == 'b') {
    //         res = numA;
    //     } else if (s.charAt(n - 1) == 'a') {
    //         res = numB;
    //     }

    //     for (int i = 0; i < n; i++) {
    //         char c = s.charAt(i);
    //         if (c == 'a') curA++;
    //         else if (c == 'b') curB++;
    //         res = Math.min(res, numA - curA + curB);
    //     }

    //     return res;
    // }
}