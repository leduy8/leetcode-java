package src.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1828 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countPoints(new int[][] {{1,3},{3,3},{5,3},{2,2}}, new int[][] {{2,3,1},{4,3,1},{1,1,2}}))); // [3,2,2]
        System.out.println(Arrays.toString(countPoints(new int[][] {{1,1},{2,2},{3,3},{4,4},{5,5}}, new int[][] {{1,2,2},{2,2,2},{4,3,2},{4,3,3}}))); // [2,3,2,4]
    }

    // Math + Geometry
    public static int[] countPoints(int[][] points, int[][] queries) {
        // Given A is the center point, B is the point on the circle
        // Radius of a circle formula: sqrt((B1 - A1)^2 + (B0 - A0)^2)

        List<Integer> list = new ArrayList<>();
        for (int[] query : queries) {
            int cnt = 0;
            for (int[] point : points) {
                // Check if distance is less than radius
                int distance = (int) Math.pow(point[1] - query[1], 2) + (int) Math.pow(point[0] - query[0], 2);
                int radius = (int) Math.pow(query[2], 2);
                if (distance <= radius) cnt++;
            }
            list.add(cnt);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
