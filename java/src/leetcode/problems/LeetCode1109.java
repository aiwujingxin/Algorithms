package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/1 13:20
 */
public class LeetCode1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] b : bookings) {
            diff[b[0] - 1] += b[2];
            if (b[1] - 1 + 1 < n) diff[b[1] - 1 + 1] -= b[2];
        }
        for (int i = 1; i < n; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }
}
