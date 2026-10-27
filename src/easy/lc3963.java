package src.easy;

import java.util.Arrays;

public class lc3963 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(createGrid(2, 3))); // ["..#","#.."]
        System.out.println(Arrays.toString(createGrid(3, 3))); // ["..#","#..","##."]
        System.out.println(Arrays.toString(createGrid(1, 4))); // ["...."]
    }

    public static String[] createGrid(int m, int n) {
        String[] res = new String[m];

        if (m == 1) {
            res[0] = ".".repeat(n);
            return res;
        }

        int end = 1;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            // Last row
            if (i == m - 1) {
                sb.append("#".repeat(end - 1));
                sb.append(".".repeat(n - (end - 1)));
            } else {
                for (int j = 0; j < n; j++) {
                    if (j == end - 1 || j == end) {
                        sb.append(".");
                    } else {
                        sb.append("#");
                    }
                }
                if (end < n) end++;
            }
            res[i] = sb.toString();
        }

        return res;
    }
}
