package src;

import java.util.HashSet;
import java.util.Set;

public class lc128 {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2})); // 4
        System.out.println(longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1})); // 9
        System.out.println(longestConsecutive(new int[] {1,0,1,2})); // 3
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxConsecutive = 0;

        // Fill num to Set
        for (int num : nums) {
            set.add(num);
        }

        for (int num: set) {
            // When num don't have any num before them -> Start of a sequence
            if (!set.contains(num - 1)) {
                int consecutive = 1;
                // Loop until end of sequence
                while (set.contains(num + consecutive)) {
                    consecutive++;
                }
                if (consecutive > maxConsecutive) {
                    maxConsecutive = consecutive;
                }
            }
        }

        return maxConsecutive;
    }
}
