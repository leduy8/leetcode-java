package src.medium;

public class lc2391 {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3})); // 21
        System.out.println(garbageCollection(new String[]{"MMM", "PGM", "GP"}, new int[]{3, 10})); // 37
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        
        // 1. Travel performance
        int[] travelPerf = new int[garbage.length];
        for (int i = 0; i < travel.length; i++) {
            travelPerf[i + 1] = travel[i] + travelPerf[i];
        }

        // 2. Count total garbage + find last garbage type index
        int lastP = -1;
        int lastM = -1;
        int lastG = -1;
        int totalGarbage = 0;

        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            totalGarbage += s.length();

            if (s.indexOf("P") != -1) lastP = i;
            if (s.indexOf("M") != -1) lastM = i;
            if (s.indexOf("G") != -1) lastG = i;
        }

        // 3. Calculate
        res += totalGarbage;
        if (lastP != -1) res += travelPerf[lastP];
        if (lastM != -1) res += travelPerf[lastM];
        if (lastG != -1) res += travelPerf[lastG];

        return res;
    }
}