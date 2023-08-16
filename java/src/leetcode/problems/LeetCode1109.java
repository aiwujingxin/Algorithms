package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 13:20
 */
public class LeetCode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] - 1 + 1 < diff.length) {
                diff[booking[1] - 1 + 1] -= booking[2];
            }
        }
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
