package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 5/3/25 20:40
 */
public class LeetCode2409 {

    int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] daysPresum;

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        daysPresum = new int[days.length];
        for (int i = 1; i < days.length; i++) {
            daysPresum[i] = daysPresum[i - 1] + days[i - 1];
        }
        int res = Math.min(getDays(leaveAlice), getDays(leaveBob)) - Math.max(getDays(arriveAlice), getDays(arriveBob));
        return res < 0 ? 0 : res + 1;
    }

    public int getDays(String s) {
        char[] chars = s.toCharArray();
        int month = (chars[0] - '0') * 10 + (chars[1] - '0');
        int day = (chars[3] - '0') * 10 + (chars[4] - '0');
        if (month == 0) {
            return day;
        }
        return daysPresum[month - 1] + day;
    }
}
