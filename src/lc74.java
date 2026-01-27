package src;

public class lc74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 3)); // true
        System.out.println(searchMatrix(new int[][] {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, 13)); // false
        System.out.println(searchMatrix(new int[][] {{1}, {3}}, 3)); // true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[ints.length - 1]) {
                int l = 0;
                int r = ints.length - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (ints[m] < target) l = m + 1;
                    else if (ints[m] > target) r = m - 1;
                    else return true;
                }
                return false;
            }
        }
        return false;
    }
}
