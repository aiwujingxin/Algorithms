package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/18 00:31
 */
public class LeetCode1594 {

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];
        int mod = 1000000007;
        maxDP[0][0] = grid[0][0];
        minDP[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxDP[i][0] = (maxDP[i - 1][0] * grid[i][0]);
            minDP[i][0] = (maxDP[i - 1][0] * grid[i][0]);
        }
        for (int i = 1; i < n; i++) {
            maxDP[0][i] = (maxDP[0][i - 1] * grid[0][i]);
            minDP[0][i] = (minDP[0][i - 1] * grid[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxDP[i][j] = max(
                        (maxDP[i - 1][j] * (long) grid[i][j]),
                        (maxDP[i][j - 1] * (long) grid[i][j]),
                        (minDP[i][j - 1] * (long) grid[i][j]),
                        (minDP[i - 1][j] * (long) grid[i][j]));
                minDP[i][j] = min(
                        (maxDP[i - 1][j] * (long) grid[i][j]),
                        (maxDP[i][j - 1] * (long) grid[i][j]),
                        (minDP[i][j - 1] * (long) grid[i][j]),
                        (minDP[i - 1][j] * (long) grid[i][j]));
            }
        }
        int res = (int) (maxDP[m - 1][n - 1] % mod);
        if (res < 0)
            return -1;
        return res % mod;
    }

    public long max(long a, long b, long c, long d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    public long min(long a, long b, long c, long d) {
        return Math.min(Math.min(a, b), Math.min(c, d));
    }
}
