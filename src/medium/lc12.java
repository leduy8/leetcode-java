package src.medium;

public class lc12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749)); // MMMDCCXLIX
        System.out.println(intToRoman(58)); // LVIII
        System.out.println(intToRoman(1994)); // MCMXCIV
    }

    public static String intToRoman(int num) {
        String[] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < symbols.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
