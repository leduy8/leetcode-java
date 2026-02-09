package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc90 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2})); // [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(subsetsWithDup(new int[] {0})); // [[],[0]]
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetDFS(0, nums, new ArrayList<>(), res);
        return res;
    }

    // Backtracking
    public static void subsetDFS(int index, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        // Record the current subset
        res.add(new ArrayList<>(cur));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue; // Skip duplicates

            cur.add(nums[i]); // Choose
            subsetDFS(i + 1, nums, cur, res); // Explore
            cur.removeLast(); // Unchoose
        }
    }
}
