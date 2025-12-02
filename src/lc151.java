package src;

public class lc151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // "blue is sky the"
        System.out.println(reverseWords("  hello world  ")); // "world hello"
        System.out.println(reverseWords("a good   example")); // "example good a"
        System.out.println(reverseWords("a")); // "a"
        System.out.println(reverseWords(" ")); // ""
    }
    
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0;
        int right = words.length - 1;
        
        while (left <= right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            
            left++;
            right--;
        }
        
        return String.join(" ", words);
    }
}
