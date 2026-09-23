package src.medium;

import java.util.*;

public class lc904 {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {1, 2, 1})); // 3
        System.out.println(totalFruit(new int[] {0, 1, 2, 2})); // 3
        System.out.println(totalFruit(new int[] {1, 2, 3, 2, 2})); // 4
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFruits = 0;
        int l = 0;

        for (int r = 0; r < fruits.length; r++) {
            map.compute(fruits[r], (k,v) -> (v == null) ? 1 : v + 1);
            
            while (map.size() > 2) {
                int freq = map.get(fruits[l]);
                if (freq == 1) map.remove(fruits[l]);
                else map.put(fruits[l], freq - 1);
                l++;
            }

            maxFruits = Math.max(maxFruits, r - l + 1);
        }

        return maxFruits;
    }
}
