package src.medium;

public class lc978 {
    public static void main(String[] args) {
        System.out.println(maxTurbulenceSize(new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9})); // 5
        System.out.println(maxTurbulenceSize(new int[] {4, 8, 12, 16})); // 2
        System.out.println(maxTurbulenceSize(new int[] {100})); // 1
    }

    public static int maxTurbulenceSize(int[] arr) {
        if (arr.length == 1) return 1;
        
        int maxTurbulenceSizeEven = 0;
        int maxTurbulenceSizeOdd = 0;
        int lEven = 0;
        int lOdd = 0;

        for (int r = 0; r < arr.length - 1; r++) {
            if (!((r % 2 == 0 && arr[r] > arr[r + 1]) || (r % 2 != 0 && arr[r] < arr[r + 1]))) {
                maxTurbulenceSizeEven = Math.max(maxTurbulenceSizeEven, r - lEven + 1);
                lEven = r + 1;
            }
            if (!((r % 2 != 0 && arr[r] > arr[r + 1]) || (r % 2 == 0 && arr[r] < arr[r + 1]))) {
                maxTurbulenceSizeOdd = Math.max(maxTurbulenceSizeOdd, r - lOdd + 1);
                lOdd = r + 1;
            }
        }

        return Math.max(
            Math.max(maxTurbulenceSizeEven, arr.length - 1 - lEven + 1),
            Math.max(maxTurbulenceSizeOdd, arr.length - 1 - lOdd + 1)
        );
    }
}
