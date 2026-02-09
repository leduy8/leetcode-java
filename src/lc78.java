package src;

import java.util.ArrayList;
import java.util.List;

public class lc78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3})); // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        System.out.println(subsets(new int[] {0})); // [[],[0]]
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetDFS(0, nums, new ArrayList<>(), res);
        return res;
    }

    // Backtracking
    public static void subsetDFS(int index, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        // Record the current subset
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]); // Choose
            subsetDFS(i + 1, nums, cur, res); // Explore
            cur.removeLast(); // Unchoose
        }
    }
}
