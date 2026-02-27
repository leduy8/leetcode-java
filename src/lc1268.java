package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1268 {
    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[] {"havana"}, "havana"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        
        Trie trie = new Trie();
        for (String p: products) {
            trie.insert(p);
        }
        
        StringBuilder currentSearchKeyword = new StringBuilder();
        Arrays.sort(products);
        
        for (char c: searchWord.toCharArray()) {
            currentSearchKeyword.append(c);
            List<String> temp = new ArrayList<>();
            for (String p: products) {
                if (p.startsWith(currentSearchKeyword.toString())) {
                    temp.add(p);
                    if (temp.size() == 3) break;
                }
            }
            res.add(temp);
        }
        
        return res;
    }

    static class Trie {
        private final TrieNode root = new TrieNode();
        
        private static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
        
        public void insert(String word) {
            TrieNode node = root;
            
            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = traverse(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return traverse(prefix) != null;
        }
        
        private TrieNode traverse(String word) {
            TrieNode node = root;

            for (char c: word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) return null;
                node = node.children[idx];
            }

            return node;
        }
    }
}