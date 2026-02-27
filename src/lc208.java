package src;

import java.util.Map;

public class lc208 {
    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "apple";
        String prefix = "app";
        obj.insert(word);
        System.out.println(obj.search(word));
        System.out.println(obj.search("application"));
        System.out.println(obj.startsWith(prefix));
        System.out.println(obj.startsWith("bear"));
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