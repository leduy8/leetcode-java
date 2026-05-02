package src.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class lc994 {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},
                                                      {1,1,0},
                                                      {0,1,1}})); // 4
        
        System.out.println(orangesRotting(new int[][]{{2,1,1},
                                                      {0,1,1},
                                                      {1,0,1}})); // -1
        
        System.out.println(orangesRotting(new int[][]{{0,2}})); // 0
    }

    public static int orangesRotting(int[][] grid) {
        // Check input
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        
        // Count fresh oranges and find location of rotten oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) freshCount++;
                else if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        // No fresh orange -> No spread -> 0m
        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!queue.isEmpty()) {
            // Last minute infection flag
            boolean spreadThisMinutes = false;
            // Fixed size queue (Prevent queue size change from update queue when infect)
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                
                for (int[] dir : directions) {
                    // Check adjacent orange by direction
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    
                    // Check boundary then infect
                    if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        freshCount--;
                        spreadThisMinutes = true;
                    }
                }
            }
            
            if (spreadThisMinutes) minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}
