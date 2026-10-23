package src.medium;

import java.util.*;

public class lc692 {
    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i","love","leetcode","i","love","coding"}, 2)); // ["i", "love"]
        System.out.println(topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"}, 4)); // ["the","is","sunny","day"]
    }

    static class WordCount {
        String word;
        int count;
    
        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<WordCount> heap = new PriorityQueue<>((a,b) -> {
            if (a.count != b.count) {
                return Integer.compare(b.count, a.count);
            }
            return a.word.compareTo(b.word);
        });
        List<String> res = new ArrayList<>();

        for (String s : words) {
            map.compute(s, (key, val) -> (val == null) ? 1 : val + 1);
        }

        map.forEach((key, val) -> {
            heap.add(new WordCount(key, val));
        });

        while (k > 0) {
            WordCount wc = heap.poll();
            res.add(wc.word);
            k--;
        }

        return res;
    }
}
