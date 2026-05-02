package src.medium;

public class lc200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {{'1','1','1','1','0'},
                                                    {'1','1','0','1','0'},
                                                    {'1','1','0','0','0'},
                                                    {'0','0','0','0','0'}})); // 1

        System.out.println(numIslands(new char[][] {{'1','1','0','0','0'},
                                                    {'1','1','0','0','0'},
                                                    {'0','0','1','0','0'},
                                                    {'0','0','0','1','1'}})); // 3
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return islands;
    }
    
    public static void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == '0') {
            return;
        }
        
        if (grid[row][col] == '1') grid[row][col] = '0';
        
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
