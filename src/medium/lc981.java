package src.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lc981 {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        String param_2 = obj.get("foo", 1);
        System.out.println(param_2); // bar
        obj.set("foo", "bar2", 2);
        String param_3 = obj.get("foo", 2);
        System.out.println(param_3); // bar2
        String param_4 = obj.get("foo", 3);
        System.out.println(param_4); // bar2
    }

    static class TimeMap {
        static class Pair {
            int timestamp;
            String value;
    
            public Pair(int timestamp, String value) {
                this.timestamp = timestamp;
                this.value = value;
            }
        }
    
        Map<String, ArrayList<Pair>> map;
    
        public TimeMap() {
            map = new HashMap<>();
        }
        
        public void set(String key, String value, int timestamp) {
            Pair pair = new Pair(timestamp, value);
            ArrayList<Pair> tmp;
            
            if (map.containsKey(key)) tmp = map.get(key);
            else tmp = new ArrayList<Pair>();
            
            tmp.add(pair);
            map.put(key, tmp);
        }
        
        public String get(String key, int timestamp) {
            ArrayList<Pair> tmp = map.get(key);
            if (tmp == null) return "";
            
            // Binary Search
            int l = 0;
            int r = tmp.size() - 1;
            String ans = "";
            
            while (l <= r) {
                int m = l + (r - l) / 2;
                Pair p = tmp.get(m);
    
                if (p.timestamp <= timestamp) {
                    ans = p.value;
                    l = m + 1;
                } else r = m - 1;
            
            }
            
            return ans;
        }
    }
}
