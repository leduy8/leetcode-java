package src.school.programmers.co.kr.course30;

import java.util.Arrays;

public class lesson178870 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, 7))); // [2,3]
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1, 2, 3, 4, 5}, 5))); // [6,6]
        System.out.println(Arrays.toString(solution(new int[] {2, 2, 2, 2, 2}, 6))); // [0,2]
    }

    public static int[] solution(int[] sequence, int k) {
        int sum = 0;
        int leftIdx = 0;
        int bestStart = 0;
        int bestEnd = sequence.length - 1;

        for (int rightIdx = 0; rightIdx < sequence.length; rightIdx++) {
            sum += sequence[rightIdx];
            
            // Shrink window
            while (sum > k) sum -= sequence[leftIdx++];
            
            if (sum == k && bestEnd - bestStart > rightIdx - leftIdx) {
                bestStart = leftIdx;
                bestEnd = rightIdx;
            }
        }

        return new int[] {bestStart, bestEnd};
    }
}
