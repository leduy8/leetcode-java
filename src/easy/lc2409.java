package src.easy;

public class lc2409 {
    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19")); // 3
        System.out.println(countDaysTogether("10-01", "10-31", "11-01", "12-31")); // 0
    }

    public static int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysPerMonth = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Alice
        int startAliceMM = parseNum(arriveAlice, "MM");
        int startAliceDD = parseNum(arriveAlice, "DD");
        int endAliceMM = parseNum(leaveAlice, "MM");
        int endAliceDD = parseNum(leaveAlice, "DD");
        // Bob
        int startBobMM = parseNum(arriveBob, "MM");
        int startBobDD = parseNum(arriveBob, "DD");
        int endBobMM = parseNum(leaveBob, "MM");
        int endBobDD = parseNum(leaveBob, "DD");
        // Start-End
        int startMM = 0;
        int startDD = 0;
        int endMM = 0;
        int endDD = 0;

        if (startAliceMM > endBobMM || (startAliceMM == endBobMM && startAliceDD > endBobDD) || startBobMM > endAliceMM || (startBobMM == endAliceMM && startBobDD > endAliceDD)) {
            return 0;
        }

        if (startAliceMM < startBobMM) {
            startMM = startBobMM;
            startDD = startBobDD;
        } else if (startAliceMM > startBobMM) {
            startMM = startAliceMM;
            startDD = startAliceDD;
        } else {
            startMM = startBobMM;
            if (startAliceDD < startBobDD) {
                startDD = startBobDD;
            } else {
                startDD = startAliceDD;
            }
        }

        if (endAliceMM < endBobMM) {
            endMM = endAliceMM;
            endDD = endAliceDD;
        } else if (endAliceMM > endBobMM) {
            endMM = endBobMM;
            endDD = endBobDD;
        } else {
            endMM = endBobMM;
            if (endAliceDD < endBobDD) {
                endDD = endAliceDD;
            } else {
                endDD = endBobDD;
            }
        }

        int days = 0;
        for (int i = startMM; i <= endMM; i++) {
            if (i == endMM && startMM == endMM && startDD <= endDD) {
                days += endDD - startDD + 1;
            } else if (i == startMM && startDD != 0) {
                days += daysPerMonth[i - 1] - startDD + 1;
            } else if (i == endMM && endDD != 0) {
                days += endDD;
            } else {
                days += daysPerMonth[i - 1];
            }
        }

        return days;
    }

    public static int parseNum(String date, String type) {
        String[] dateArr = date.split("-");
        if (type.equals("MM"))
            return Integer.parseInt(dateArr[0]);
        return Integer.parseInt(dateArr[1]);
    }
}
