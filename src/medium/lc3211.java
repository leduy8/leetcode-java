package src.medium;

import java.util.ArrayList;
import java.util.List;

public class lc3211 {
    private static final List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(validStrings(3)); // ["010","011","101","110","111"]
        System.out.println(validStrings(1)); // ["0","1"]
    }
    
    public static List<String> validStrings(int n) {
        list.clear();
        backtracking("", n);
        return list;
    }

    public static void backtracking(String curStr, int n) {
        if (curStr.length() == n) {
            list.add(curStr);
            return;
        }

        // Always safe to add 1
        backtracking(curStr + "1", n);
        // Accepts first char is 0 or no adjacent zeros
        if (curStr.length() == 0 || curStr.charAt(curStr.length() - 1) != '0') {
            backtracking(curStr + "0", n);
        }
    }
}
