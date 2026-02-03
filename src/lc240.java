package src;

public class lc240 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5)); // true
        System.out.println(searchMatrix(new int[][] {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20)); // false
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Start from upper right of the matrix
        int row = 0;
        int col = matrix[0].length - 1;

        // As long as row or col not out of bound
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            // Shift column to the left
            else if (matrix[row][col] > target) col--;
            // Shift row to the bottom
            else row++;
        }

        return false;
    }

//    Binary Search way
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        for (int[] arr: matrix) {
//            boolean found = binarySearch(arr, target);
//            if (found) return true;
//        }
//
//        return false;
//    }
//    
//    public static boolean binarySearch(int[] arr, int target) {
//        int l = 0;
//        int r = arr.length - 1;
//        
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            
//            if (arr[m] == target) return true;
//            else if (arr[m] < target) l = m + 1;
//            else r = m - 1;
//        }
//        
//        return false;
//    }
}
