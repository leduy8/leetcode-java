package src.easy;

public class lc2485 {
    public static void main(String[] args) {
        System.out.println(pivotInteger(8)); // 6
        System.out.println(pivotInteger(1)); // 1
        System.out.println(pivotInteger(4)); // -1
    }

    public static int pivotInteger(int n) {
        int[] leftSum = new int[n];
        int tmp = 0;

        for (int i = 1; i <= n; i++) {
            tmp += i;
            leftSum[i - 1] = tmp;
        }

        for (int i = 1; i <= n; i++) {
            if (leftSum[n - 1] - leftSum[i - 1] + i == leftSum[i - 1]) {
                return i;
            }
        }

        return -1;
    }
}
