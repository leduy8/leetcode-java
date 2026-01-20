package src;


import java.util.*;

public class lc49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"})); // [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(groupAnagrams(new String[] {""})); // [[""]]
        System.out.println(groupAnagrams(new String[] {"a"})); // [["a"]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word: strs) {
            String sort = sortedStr(word);
            map.putIfAbsent(sort, new ArrayList<>());
            map.get(sort).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public static String sortedStr(String word) {
        char[] c = word.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
