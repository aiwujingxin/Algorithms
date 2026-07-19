package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/23/26 19:38
 */
public class LeetCode3882 {
    int m;
    int n;
    int[][][] dp;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][1024];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        return dfs(grid, 0, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j, int state) {
        if (i == m - 1 && j == n - 1) return state ^ grid[i][j];
        if (i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;
        if (dp[i][j][state] != Integer.MAX_VALUE) return dp[i][j][state];
        int r = dfs(grid, i + 1, j, state ^ grid[i][j]);
        int d = dfs(grid, i, j + 1, state ^ grid[i][j]);
        dp[i][j][state] = Math.min(r, d);
        return dp[i][j][state];
    }
}
