package src.DeMau;

public class Bai3 {
    public static void main(String[] args) {
        System.out.println(bai3(new int[][] {{0, 0, 0, 1, 1, 1, 0, 0}, 
                                             {0, 0, 0, 0, 1, 1, 0, 0}, 
                                             {1, 1, 0, 0, 0, 1, 1, 0}, 
                                             {1, 1, 1, 0, 0, 0, 0, 0}, 
                                             {1, 1, 1, 0, 0, 0, 1, 1}})); // 9

        System.out.println(bai3(new int[][] {{1, 0, 1, 0, 1, 1}, 
                                             {1, 0, 1, 0, 0, 0}, 
                                             {1, 0, 1, 0, 0, 1}, 
                                             {1, 0, 0, 1, 0, 0}, 
                                             {1, 0, 0, 1, 0, 1}, 
                                             {1, 0, 0, 0, 0, 0}, 
                                             {1, 1, 1, 1, 1, 1}})); // 16
    }

    public static int bai3(int[][] land) {
        int maxOil = 0;
        int rows = land.length;
        int cols = land[0].length;

        for (int j = 0; j < cols; j++) {
            int currentOil = 0;
            int[][] landCopy = clone2DArray(land);
            for (int i = 0; i < rows; i++) {
                if (landCopy[i][j] == 1) {
                    currentOil += dfs(landCopy, i, j);
                }
            }
            maxOil = Math.max(maxOil, currentOil);
        }

        return maxOil;
    }
    
    public static int dfs(int[][] land, int row, int col) {
        int rows = land.length;
        int cols = land[0].length;

        // Check biên và kiểm tra xem vị trí hiện tại có dầu không
        if (row < 0 || col < 0 || row >= rows || col >= cols || land[row][col] == 0) {
            return 0;
        }
        
        land[row][col] = 0; // Đã được duyệt qua

        int oil = 1; // Khi đến bước này, chứng tỏ vị trí hiện tại có dầu
        oil += dfs(land, row + 1, col);
        oil += dfs(land, row - 1, col);
        oil += dfs(land, row, col + 1);
        oil += dfs(land, row, col - 1);

        return oil;
    }
    
    public static int[][] clone2DArray(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];
        
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        
        return copy;
    }
}
