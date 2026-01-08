package src;

public class lc392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false 
        System.out.println(isSubsequence("aaaaaa", "bbaaaa")); // false 
    }

    // Solve in String way
    public static boolean isSubsequence(String s, String t) {
        for (char c: s.toCharArray()) {
            String newT = findAndRemoveHead(c, t);
            if (newT.equals(t)) {
                return false;
            }
            t = newT;
        }

        return true;
    }
    
    public static String findAndRemoveHead(char target, String t) {
        int i = t.indexOf(String.valueOf(target));
        return t.substring(i + 1);
    }
}
