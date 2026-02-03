package src;

import java.util.Arrays;

public class lc48 {
    public static void main(String[] args) {
        rotate(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}); // [[7,4,1],[8,5,2],[9,6,3]]
        rotate(new int[][] {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}}); // [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }

    public static void rotate(int[][] matrix) {
        System.out.println("Before rotate: ");
        printMatrix(matrix);

        int n = matrix.length;

        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Row reversal
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }

        System.out.println("After rotate: ");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] a: matrix) {
            System.out.println(Arrays.toString(a));
        }
    }
}
