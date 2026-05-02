package src.medium;

public class lc695 {
    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                                                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                                                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                                                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                                                        {0,0,0,0,0,0,0,1,1,0,0,0,0}})); // 6

        System.out.println(maxAreaOfIsland(new int[][] {{0,0,0,0,0,0,0,0}})); // 0
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxLand = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxLand = Math.max(bfs(grid, r, c), maxLand);
            }
        }

        return maxLand;
    }

    public static int bfs(int[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        int land = 1;
        grid[r][c] = 0;

        land += bfs(grid, r - 1, c);
        land += bfs(grid, r + 1, c);
        land += bfs(grid, r, c - 1);
        land += bfs(grid, r, c + 1);

        return land;
    }
}
