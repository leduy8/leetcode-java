package src.easy;

public class lc1351 {
    public static void main(String[] args) {
        System.out.println(countNegatives(new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}})); // 8
        System.out.println(countNegatives(new int[][] {{3,2},{1,0}})); // 0
    }

    // O(n + m) time, O(1) space
    public static int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int curRow = n - 1;
        int curCol = 0;
        int cnt = 0;

        while (curRow >= 0 && curCol < m) {
            if (grid[curRow][curCol] < 0) {
                cnt += m - curCol;
                curRow--;
                curCol = 0;
            } else {
                curCol++;
            }
            
        }

        return cnt;
    }
}
