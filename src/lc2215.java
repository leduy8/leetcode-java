package src;

import java.util.*;

public class lc2215 {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6})); // [[1,3],[4,6]]
        System.out.println(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2})); // [[3],[]]
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Create 2 sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Loop and populate data
        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        // Make result sets
        Set<Integer> only1 = new HashSet<>(set1);
        Set<Integer> only2 = new HashSet<>(set2);

        // Remove differences
        only1.removeAll(set2);
        only2.removeAll(set1);

        // Return data as List
        return List.of(
                new ArrayList<>(only1),
                new ArrayList<>(only2)
        );
    }
}