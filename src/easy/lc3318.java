package src.easy;

import java.util.*;

public class lc3318 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2))); // [6, 10, 12]
        System.out.println(Arrays.toString(findXSum(new int[]{3, 8, 7, 8 , 7, 5}, 2, 2))); // [11, 15, 15, 15, 12]
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<int[]> set = new TreeSet<>((a,b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(b[1], a[1]); // Higher freq first
            }
            return Integer.compare(b[0], a[0]); // Higher num first
        });

        for (int r = 0; r < nums.length; r++) {
            int curNum = nums[r];
            int oldFreq = map.getOrDefault(curNum, 0);

            if (oldFreq > 0) {
                set.remove(new int[]{curNum, oldFreq});
            }

            int newFreq = oldFreq + 1;
            set.add(new int[]{curNum, newFreq});
            map.compute(curNum, (key,val) -> (val == null) ? 1 : val + 1);

            // If window exceed k
            if (r - l + 1 > k) {
                int numToRemove = nums[l];
                int numToRemoveFreq = map.get(numToRemove);
                set.remove(new int[]{numToRemove, numToRemoveFreq});
                if (numToRemoveFreq > 1) {
                    map.put(numToRemove, numToRemoveFreq - 1);
                    set.add(new int[]{numToRemove, numToRemoveFreq - 1});
                } else {
                    map.remove(numToRemove);
                }
                l++;
            }

            res[l] = getXSum(set, x);
        }

        return res;
    }

    public static int getXSum(TreeSet<int[]> set, int x) {
        int count = 0;
        int sum = 0;

        for (int[] entry : set) {
            if (count == x) break;
            sum += entry[0] * entry[1];
            count++;
        }

        return sum;
    }
}
