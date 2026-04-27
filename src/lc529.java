package src;

public class lc529 {
    //    The Rules of the Game
    //    1. 'M' (Unrevealed Mine): If you click this, change it to 'X' (Game Over).
    //    2. 'E' (Unrevealed Empty Square):
    //        If it has adjacent mines, change it to a digit ('1' to '8') representing the mine count.
    //        If it has no adjacent mines, change it to 'B' (Blank) and recursively reveal all its neighbors.
    //    3. 'B', 'X', or Digit: If you click an already revealed square, do nothing.

    public static void main(String[] args) {
        updateBoard(new char[][] {{'E','E','E','E','E'},
                                  {'E','E','M','E','E'},
                                  {'E','E','E','E','E'},
                                  {'E','E','E','E','E'}}, new int[] {3,0}); // [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
        System.out.println("======================================================");
        updateBoard(new char[][] {{'B','1','E','1','B'},
                                  {'B','1','M','1','B'},
                                  {'B','1','1','1','B'},
                                  {'B','B','B','B','B'}}, new int[] {1,2}); // [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
    }

    // Directions for 8 neighbors (Horizontal, Vertical, Diagonal)
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static char[][] updateBoard(char[][] board, int[] click) {
        printBoard(board, "Before");

        int r = click[0];
        int c = click[1];

        // Rule 1: Hit a mine
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            printBoard(board, "After");
            return board;
        }

        dfs(board, r, c);
        printBoard(board, "After");

        return board;
    }

    public static void dfs(char[][] board, int r, int c) {
        // Base case: check bounds and if we're on an unrevealed empty square
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'E') {
            return;
        }

        // Count adjacent mines
        int mineCount = countMines(board, r, c);

        if (mineCount > 0) {
            // Rule 2: Has adjacent mines, stop recursion
            board[r][c] = (char) (mineCount + '0');
        } else {
            // Rule 3: No adjacent mines, change to 'B' and recurse
            board[r][c] = 'B';
            for (int[] dir : directions) {
                dfs(board, r + dir[0], c + dir[1]);
            }
        }
    }

    public static int countMines(char[][] board, int r, int c) {
        int count = 0;
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                if (board[nr][nc] == 'M') count++;
            }
        }
        return count;
    }

    public static void printBoard(char[][] board, String text) {
        System.out.println(text);

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                System.out.printf("%c ", board[r][c]);
            }
            System.out.println();
        }
    }
}
