package src.medium;

import java.util.Arrays;

public class lc1769 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("110"))); // [1,1,3]
        System.out.println(Arrays.toString(minOperations("001011"))); // [11,8,5,4,3,4]
    }

    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];

        // Accumulate moves from left
        int ballsLeft = 0;
        int movesLeft = 0;
        for (int i = 0; i < len; i++) {
            res[i] += movesLeft;
            if (boxes.charAt(i) == '1') {
                ballsLeft++;
            }
            movesLeft += ballsLeft;
        }

        // Accumulate moves from right
        int ballsRight = 0;
        int movesRight = 0;
        for (int i = len - 1; i >= 0; i--) {
            res[i] += movesRight;
            if (boxes.charAt(i) == '1') {
                ballsRight++;
            }
            movesRight += ballsRight;
        }

        return res;
    }
}
