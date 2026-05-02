package src.medium;

public class lc130 {
    public static void main(String[] args) {
        solve(new char[][] {{'X','X','X','X'},
                            {'X','O','O','X'},
                            {'X','X','O','X'},
                            {'X','O','X','X'}});

        solve(new char[][] {{'X'}});
    }

    public static void solve(char[][] board) {
        System.out.println("Before");
        printBoard(board);

        int rows = board.length;
        int cols = board[0].length;

        // Traverse from border inside (Every 'O' we found is automatically "safe" and marked them as "#")
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }

        System.out.println("After marked");
        printBoard(board);

        // Flip O with X (Trapped O)
        // Flip # with O (Safe 0)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // Trapped
                else if (board[i][j] == '#') board[i][j] = 'O'; // Safe
            }
        }

        System.out.println("After");
        printBoard(board);
    }
    
    public static void dfs(char[][] board, int r, int c) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Boundary and 'O' check
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != 'O') return;
        
        // Mark visited/safe
        board[r][c] = '#';
        
        // Explore neighbors
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
    
    public static void printBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(board[r][c]);
            }
            System.out.println();
        }
    }
}
