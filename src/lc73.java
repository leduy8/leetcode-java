package src;

import java.util.Arrays;

public class lc73 {
    public static void main(String[] args) {
        setZeroes(new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}); // [[1,0,1],[0,0,0],[1,0,1]]
        setZeroes(new int[][] {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}); // [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];
        
        System.out.println("Before");
        printMatrix(matrix);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // Remember the 0 location
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }

        // Fill rows with 0s
        for (int i = 0; i < rows; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Fill cols with 0s
        for (int j = 0; j < cols; j++) {
            if (zeroCols[j]) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("After");
        printMatrix(matrix);
    }
    
    public static void printMatrix(int[][] matrix) {
        for (int[] a: matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}
