package src;

import java.util.Set;

public class lc345 {
    static final Set<Character> VOWELS = Set.of('a', 'u', 'i', 'e', 'o', 'A', 'U', 'I', 'E', 'O');
    
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm")); // AceCreIm
        System.out.println(reverseVowels("leetcode")); // leotcede
    }
    
    public static String reverseVowels(String s) {
        char[] res = s.toCharArray();
        int left = 0;
        int right = res.length - 1;
        
        while (left < right) {
            while (left < right && !isVowel(res[left])) left++;
            while (left < right && !isVowel(res[right])) right--;
            
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(res);
    }
    
    public static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}
