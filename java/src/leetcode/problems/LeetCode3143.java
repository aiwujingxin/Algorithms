package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/9/25 15:15
 */
public class LeetCode3143 {

    public int maxPointsInsideSquare(int[][] points, String s) {
        int l = 0;
        int r = 0;
        for (int[] p : points) {
            r = Math.max(Math.max(Math.abs(p[0]), Math.abs(p[1])), r);
        }
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (check(m, points, s)) l = m;
            else r = m - 1;
        }
        if (check(l, points, s)) {
            return cal(l, points);
        }
        return cal(l - 1, points);
    }

    private boolean check(int len, int[][] points, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < points.length; i++) {
            if (Math.abs(points[i][0]) <= len && Math.abs(points[i][1]) <= len) {
                int index = s.charAt(i) - 'a';
                if (freq[index] > 0) return false;
                freq[index]++;
            }
        }
        return true;
    }

    private int cal(int len, int[][] points) {
        int cnt = 0;
        for (int[] point : points) {
            if (Math.abs(point[0]) <= len && Math.abs(point[1]) <= len) {
                cnt++;
            }
        }
        return cnt;
    }
}
