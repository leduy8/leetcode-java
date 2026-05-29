package src.school.programmers.co.kr.course30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lesson154540 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        }))); // [1,1,27]

        System.out.println(Arrays.toString(solution(new String[]{
                "XXX",
                "XXX",
                "XXX"
        }))); // [-1]
    }

    public static int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        int rows = maps.length;
        int cols = maps[0].length();
        char[][] mapsChar = convertToCharMaps(maps);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int n = dfs(mapsChar, r, c);
                if (n != 0) {
                    answer.add(n);
                }
            }
        }

        return !answer.isEmpty() ? answer.stream().sorted().mapToInt(Integer::intValue).toArray() : new int[] {-1};
    }


    public static int dfs(char[][] mapsChar, int r, int c) {
        if (r < 0 || c < 0 || r >= mapsChar.length || c >= mapsChar[0].length || mapsChar[r][c] == 'X') {
            return 0;
        }

        int val = mapsChar[r][c] - '0';
        mapsChar[r][c] = 'X'; // mark visited

        return val
                + dfs(mapsChar, r + 1, c)
                + dfs(mapsChar, r - 1, c)
                + dfs(mapsChar, r, c + 1)
                + dfs(mapsChar, r, c - 1);
    }


    public static char[][] convertToCharMaps(String[] maps) {
        char[][] m = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            m[i] = maps[i].toCharArray();
        }
        return m;
    }
}
