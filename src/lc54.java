package src;

import java.util.ArrayList;
import java.util.List;

public class lc54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][] {{1,2,3},{4,5,6}, {7,8,9}})); // [1,2,3,6,9,8,7,4,5]
        System.out.println(spiralOrder(new int[][] {{1,2,3,4},{5,6,7,8}, {9,10,11,12}})); // [1,2,3,4,8,12,11,10,9,5,6,7]
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> spiral = new ArrayList<>();

        while (up <= down && left <= right) {
            // No need to check due to while condition already check for it
            for (int i = left; i <= right; i++)
                spiral.add(matrix[up][i]);
            up++;

            // No need to check due to while condition already check for it
            for (int j = up; j <= down; j++)
                spiral.add(matrix[j][right]);
            right--;

            // Condition check to make sure there's a row left
            if (up <= down) {
                for (int k = right; k >= left; k--)
                    spiral.add(matrix[down][k]);
                down--;
            }

            // Condition check to make sure there's a column left
            if (left <= right) {
                for (int l = down; l >= up; l--)
                    spiral.add(matrix[l][left]);
                left++;
            }
        }

        return spiral;
    }
}
