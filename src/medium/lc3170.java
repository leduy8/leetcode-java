package src.medium;

import java.util.ArrayList;
import java.util.List;
// import java.util.PriorityQueue;

public class lc3170 {
    public static void main(String[] args) {
        System.out.println(clearStars("aaba*")); // aab
        System.out.println(clearStars("abc")); // abc
    }

    public static String clearStars(String s) {
        int len = s.length();
        List<Integer>[] pos = new ArrayList[26];
        boolean[] deleted = new boolean[len];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            pos[i] = new ArrayList<>();
        }

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                // Mark delete
                deleted[i] = true;
                // Find smallest character with highest position
                for (int j = 0; j < 26; j++) {
                    if (!pos[j].isEmpty()) {
                        int idx = pos[j].remove(pos[j].size() - 1);
                        deleted[idx] = true;
                        break;
                    }
                }
            } else {
                // Keep the latest index of each character
                pos[c - 'a'].add(i);
            }
        }
        
        // Build string
        for (int i = 0; i < len; i++) {
            if (!deleted[i]) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    // Heap
    // public static String clearStars(String s) {
    //     char[] sArr = s.toCharArray();

    //     PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> {
    //         if (a[0] != b[0]) {
    //             return Integer.compare(a[0], b[0]);
    //         }
    //         return Integer.compare(b[1], a[1]);
    //     });

    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (c == '*') {
    //             int[] cur = heap.poll();
    //             sArr[cur[1]] = 'N';
    //         } else {
    //             heap.add(new int[] {(int) s.charAt(i), i});
    //         }
    //     }

    //     StringBuilder sb = new StringBuilder();
    //     for (char c : sArr) {
    //         if (c == '*') continue;
    //         if (c != 'N') {
    //             sb.append(c);
    //         }
    //     }

    //     return sb.toString();
    // }
}
