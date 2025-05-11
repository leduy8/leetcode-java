package src;

import java.util.*;

public class lc771 {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb")); // 3
        System.out.println(numJewelsInStones("z", "ZZ")); // 0
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int jewelCount = 0;

        Set<Character> jewelBox = new HashSet<>();
        for (char c : jewels.toCharArray()) {
            jewelBox.add(c);
        }

        for (char c : stones.toCharArray()) {
            if (jewelBox.contains(c)) {
                jewelCount++;
            }
        }

        return jewelCount;
    }
}
