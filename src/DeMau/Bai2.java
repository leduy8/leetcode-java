package src.DeMau;

public class Bai2 {
    public static void main(String[] args) {
        System.out.println(bai2(0,5,30,0,7,0)); // 2
        System.out.println(bai2(12,0,0,12,0,30)); // 1
        System.out.println(bai2(0,6,1,0,6,6)); // 0
        System.out.println(bai2(11,59,30,12,0,0)); // 1
        System.out.println(bai2(11,58,59,11,59,0)); // 1
        System.out.println(bai2(1,5,5,1,5,6)); // 2
        System.out.println(bai2(0,0,0,23,59,59)); // 2852
    }

    public static int bai2(int h1, int m1, int s1, int h2, int m2, int s2) {
        // Chuyển thời gian về giây kể từ 00:00:00
        long t1 = h1 * 3600L + m1 * 60L + s1;
        long t2 = h2 * 3600L + m2 * 60L + s2;

        // Chu kỳ trùng nhau (đơn vị: giây)
        double T_sm = 3600.0 / 59.0;     // giây – phút
        double T_sh = 43200.0 / 719.0;   // giây – giờ
        long T_both = 43200L;            // trùng cả hai

        // Hàm đếm số lần xảy ra trong (t1, t2]
        int countSM = countEvents(t1, t2, T_sm);
        int countSH = countEvents(t1, t2, T_sh);
        int countBoth = countEvents(t1, t2, T_both);

        return countSM + countSH - countBoth;
    }

    private static int countEvents(long start, long end, double period) {
        long a = (long) Math.floor(end / period);
        long b = (long) Math.floor(start / period);
        return (int) (a - b);
    }

    private static int countEvents(long start, long end, long period) {
        long a = end / period;
        long b = start / period;
        return (int) (a - b);
    }
}
