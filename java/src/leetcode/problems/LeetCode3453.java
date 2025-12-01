package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 11/19/25 15:02
 */
public class LeetCode3453 {

    double[] area;
    double sum = 0;
    double epss = 1e-6;

    public double separateSquares(int[][] squares) {
        double l = Integer.MAX_VALUE;
        double r = Integer.MIN_VALUE;
        int n = squares.length;
        area = new double[n];
        for (int i = 0; i < n; i++) {
            int[] s = squares[i];
            l = Math.min(l, s[1]);
            r = Math.max(r, s[1] + s[2]);
            double t = (double) s[2] * (double) s[2] / epss;
            area[i] = t;
            sum += t;
        }
        while (r - l > epss) {
            double mid = (l + r) / 2;
            if (check(mid, squares)) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean check(double mid, int[][] squares) {
        double up = 0;
        for (int i = 0; i < squares.length; i++) {
            int[] s = squares[i];
            if (mid > s[1] && mid < s[1] + s[2]) {
                up += (s[1] + s[2] - mid) / (s[2]) * area[i];
            }
            if (mid <= s[1]) {
                up += area[i];
            }
        }
        return up * 2 - sum <= 0;
    }
}
