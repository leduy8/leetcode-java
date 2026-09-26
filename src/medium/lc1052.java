package src.medium;

public class lc1052 {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3)); // 16
        System.out.println(maxSatisfied(new int[] {4,10,10}, new int[] {1,1,0}, 2)); // 24
        System.out.println(maxSatisfied(new int[] {3,8,8,8}, new int[] {1,1,1,1}, 3)); // 19
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satifiedCustomer = 0;
        int extraCustomer = 0;
        int curExtra = 0;
        int l = 0;

        for (int r = 0; r < grumpy.length; r++) {
            if (grumpy[r] == 0) {
                satifiedCustomer += customers[r];
            }
            if (grumpy[r] == 1) {
                curExtra += customers[r];
            }
            while (r - l + 1 > minutes) {
                if (grumpy[l] == 1) {
                    curExtra -= customers[l];
                }
                l++;
            }
            extraCustomer = Math.max(extraCustomer, curExtra);
        }

        return satifiedCustomer + extraCustomer;
    }
}
