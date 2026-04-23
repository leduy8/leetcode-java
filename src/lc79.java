package src;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc79 {
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}}, "ABCCED")); // true
        
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}}, "SEE")); // true
        
        System.out.println(exist(new char[][]{{'A','B','C','E'},
                                              {'S','F','C','S'},
                                              {'A','D','E','E'}}, "ABCB")); // false
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, r, c, word, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static boolean dfs(char[][] board, int r, int c, String word, int curWordPos) {
        int rows = board.length;
        int cols = board[0].length;

        // Boundary and invalid character check
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(curWordPos)) {
            return false;
        }
        
        // Check last character, if character is last of word -> Found word 
        if (curWordPos == word.length() - 1) {
            return board[r][c] == word.charAt(curWordPos);
        }
        
        char temp = board[r][c];
        board[r][c] = '#'; // Mark visited
        
        boolean found = dfs(board, r + 1, c, word, curWordPos + 1) || 
                        dfs(board, r - 1, c, word, curWordPos + 1) || 
                        dfs(board, r, c + 1, word, curWordPos + 1) || 
                        dfs(board, r, c - 1, word, curWordPos + 1);

        board[r][c] = temp; // backtrack
        return found;
    }
}
