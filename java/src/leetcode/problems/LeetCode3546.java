package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 3/25/26 00:03
 */
public class LeetCode3546 {

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] s = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        long total = s[m][n];
        if (total % 2 != 0) return false;
        long target = total / 2;
        for (int i = 1; i <= m; i++) {
            long c = s[i - 1][n] - s[0][0];
            if (c == target) return true;
            if (c > target) break;
        }
        for (int j = 1; j <= n; j++) {
            long c = s[m][j - 1] - s[0][0];
            if (c == target) return true;
            if (c > target) break;
        }
        return false;
    }
}
