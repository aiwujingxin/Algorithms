package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 7/29/25 13:12
 */
public class LeetCode2684 {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (i - 1 >= 0 && grid[i][j] > grid[i - 1][j - 1] && dp[i - 1][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (grid[i][j] > grid[i][j - 1] && dp[i][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i + 1 < m && grid[i][j] > grid[i + 1][j - 1] && dp[i + 1][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max == 0 ? 0 : max - 1;
    }
}
