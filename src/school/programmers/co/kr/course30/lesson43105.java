package src.school.programmers.co.kr.course30;

public class lesson43105 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    public static int solution(int[][] triangle) {
        for (int r = triangle.length - 2; r >= 0; r--) {
            for (int c = 0; c < triangle[r].length; c++) {
                int left_child = triangle[r + 1][c];
                int right_child = triangle[r + 1][c + 1];
                // Bubble the max sum of leaf to root
                triangle[r][c] += Math.max(left_child, right_child);
            }
        }
        // Return root
        return triangle[0][0];
    }
}
