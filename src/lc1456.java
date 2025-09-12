package src;

public class lc1456 {
    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3)); // 3
        System.out.println(maxVowels("aeiou", 2)); // 2
        System.out.println(maxVowels("leetcode", 3)); // 2
    }

    public static int maxVowels(String s, int k) {
        int curVowel = 0;
        
        // First for loop to initialize window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                curVowel++;
            }
        }
        
        int maxVowel = curVowel;
        
        // Sliding window
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                curVowel--;
            }
            
            if (isVowel(s.charAt(i))) {
                curVowel++;
            }

            maxVowel = Math.max(maxVowel, curVowel);
        }
        
        return maxVowel;
    }
    
    public static Boolean isVowel(Character c) {
        return c == 'U' || c == 'I' || c == 'A' || c == 'E' || c == 'O' || c == 'u' || c == 'i' || c == 'a' || c == 'e' || c == 'o';
    }
}