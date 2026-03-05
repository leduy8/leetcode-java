package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1282 {
    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] {3,3,3,3,3,1,3})); // [[5],[0,1,2],[3,4,6]]
        System.out.println(groupThePeople(new int[] {2,1,3,3,3,2})); // [[1],[0,5],[2,3,4]]
        System.out.println(groupThePeople(new int[] {3,4,3,3,4,4,3,4,3,3})); // [[0,2,3],[6,8,9],[1,4,5,7]]
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < groupSizes.length; i++) {
            // groupSizes[i] means: "Person i must be in a group of exactly this size."
            int size = groupSizes[i];

            // Add person i to the bucket for this group size
            map.computeIfAbsent(size, k -> new ArrayList<>()).add(i);

            // If bucket is full, flush it to results
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }

        return result;
    }
}
