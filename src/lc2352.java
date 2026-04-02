package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc2352 {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][] {{3,2,1},{1,7,6},{2,7,7}})); // 1 [2,7,7]
        System.out.println(equalPairs(new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}})); // 3 [3,1,2,2], [2,4,2,2], [2,4,2,2]
    }

    public static int equalPairs(int[][] grid) {
        int res = 0;
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        
        for (int[] arr: grid) {
            map.merge(Arrays.toString(arr), 1, Integer::sum);
        }

        for (int col = 0; col < n; col++) {
            int[] tempArr = new int[n];
            for (int row = 0; row < n; row++) {
                tempArr[row] = grid[row][col];
            }
            String key = Arrays.toString(tempArr);
            res += map.getOrDefault(key, 0);
        }

        return res;
    }
}
