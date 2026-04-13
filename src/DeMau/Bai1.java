package src.DeMau;

public class Bai1 {
    public static void main(String[] args) {
        System.out.println(bai1(new int[] {5, 1, 5}, 30, new int[][] {{2,10}, {9,15}, {10,5}, {11,5}})); // 5
        System.out.println(bai1(new int[] {3, 2, 7}, 20, new int[][] {{1,15}, {5,16}, {8,6}})); // -1
        System.out.println(bai1(new int[] {4, 2, 7}, 20, new int[][] {{1,15}, {5,16}, {8,6}})); // -1
        System.out.println(bai1(new int[] {1, 1, 1}, 5, new int[][] {{1,2}, {3,2}})); // 3
    }

    public static int bai1(int[] bandage, int health, int[][] attacks) {
        int curHealth = health;
        int castTime = bandage[0];
        int heal = bandage[1];
        int bonusHeal = bandage[2];
        int attackIdx = 0;
        int consecutiveHeal = 0;

        for (int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            // Attack
            if (attacks[attackIdx][0] == i) {
                curHealth -= attacks[attackIdx][1];
                consecutiveHeal = 0;
                attackIdx++;
                if (curHealth <= 0) return -1;
            }
            // No attack -> heal
            else {
                consecutiveHeal++;
                curHealth += heal;
                if (consecutiveHeal == castTime) {
                    curHealth += bonusHeal;
                    consecutiveHeal = 0;
                }
                curHealth = Math.min(curHealth, health);
            }
        }

        return curHealth;
    }
}
