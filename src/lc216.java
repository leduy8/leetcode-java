package src;

import java.util.*;

public class lc216 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7)); // [[1,2,4]]
        System.out.println(combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]
        System.out.println(combinationSum3(4, 1)); // []
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombination(k, 1, n, new ArrayList<>(), ans);
        return ans;
    }

    public static void findCombination(int k, int num, int n, ArrayList<Integer> cur, List<List<Integer>> ans) {
        // If n is reached and k elements are used
        if (n == 0 && k == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = num; i < 10; i++) {
            if (i > n || k <= 0) break; // Prune unnecessary calls
            cur.add(i); // Choose the current number
            findCombination(k - 1, i + 1, n - i, cur, ans); // Recursive
            cur.remove(cur.size() - 1); // Backtrack
        }
    }
}