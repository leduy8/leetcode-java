package src;

public class lc443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'})); // 6 (a2b2c3)
        System.out.println(compress(new char[]{'a'})); // 1 (a)
        System.out.println(compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'})); // 4 (ab12)
    }

    public static int compress(char[] chars) {
        int write = 0;
        int read = 0;

        // Scan through the array
        while (read < chars.length) {
            char c = chars[read];
            int start = read;

            // Move read forward to cover the entire consecutive group of 'c'
            while (read < chars.length && chars[read] == c) {
                read++;
            }

            // Write the character that started this group
            chars[write++] = c;

            // Length of this group. If group size > 1, write each digit of the number
            int count = read - start;
            if (count > 1) {
                for (char d : String.valueOf(count).toCharArray()) {
                    chars[write++] = d;
                }
            }
        }

        return write;
    }
}
