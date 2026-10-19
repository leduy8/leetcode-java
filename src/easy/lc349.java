package src.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc349 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[] {1,2,2,1}, new int[] {2,2}))); // [2]
        System.out.println(Arrays.toString(intersection(new int[] {4,9,5}, new int[] {9,4,9,8,4}))); // [4,9]
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] freq = new int[1001];
        List<Integer> list = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < n; i++) {
            if (freq[nums1[i]] == 0) {
                freq[nums1[i]]++;
            }
        }

        for (int i = 0; i < m; i++) {
            if (freq[nums2[i]] == 1) {
                freq[nums2[i]]++;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 2) {
                list.add(i);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
