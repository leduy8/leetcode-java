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
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        int count = 0;

        // Kiểm tra xem tại thời điểm bắt đầu có trùng hay không
        if (isMatchHour(startTime) || isMatchMinute(startTime)) {
            count++;
        }

        // Duyệt qua từng giây
        for (int t = startTime; t < endTime; t++) {
            double hNow = (t * 1.0 / 120) % 360; // Kim giờ: 360 độ / 43200 giây = 1/120 độ mỗi giây
            double mNow = (t * 0.1) % 360;       // Kim phút: 360 độ / 3600 giây = 0.1 độ mỗi giây
            double sNow = (t * 6.0) % 360;       // Kim giây: 360 độ / 60 giây = 6 độ mỗi giây

            double hNext = ((t + 1) * 1.0 / 120) % 360;
            double mNext = ((t + 1) * 0.1) % 360;
            double sNext = ((t + 1) * 6.0) % 360;

            // Xử lý trường hợp kim quay về 0 độ (vượt qua mốc 12h/60p/60s)
            if (hNext == 0) hNext = 360;
            if (mNext == 0) mNext = 360;
            if (sNext == 0) sNext = 360;

            boolean matchHour = sNow < hNow && sNext >= hNext;
            boolean matchMin = sNow < mNow && sNext >= mNext;

            if (matchHour && matchMin) {
                // Nếu cả 2 đều trùng trong 1 giây, kiểm tra xem có phải trùng tại cùng 1 điểm không
                // Nếu trùng cùng 1 điểm (3 kim gặp nhau) thì chỉ +1, ngược lại +2
                if (hNext == mNext) count += 1;
                else count += 2;
            } else if (matchHour || matchMin) {
                count += 1;
            }
        }

        return count;
    }

    private static boolean isMatchHour(int t) {
        return (t * 6 % 360) == (t * 1.0 / 120 % 360);
    }

    private static boolean isMatchMinute(int t) {
        return (t * 6 % 360) == (t * 0.1 % 360);
    }
}
