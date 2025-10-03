package leetcode.problems;

/**
 * @author jingxinwu
 * @date 2022-02-25 8:25 PM
 */
public class LeetCode1219 {

    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int cnt = dfs(grid, i, j, new boolean[m][n]);
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j, boolean[][] vs) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vs[i][j] || grid[i][j] == 0) {
            return 0;
        }
        vs[i][j] = true;
        int t = 0;
        t = Math.max(t, dfs(grid, i + 1, j, vs));
        t = Math.max(t, dfs(grid, i, j + 1, vs));
        t = Math.max(t, dfs(grid, i - 1, j, vs));
        t = Math.max(t, dfs(grid, i, j - 1, vs));
        vs[i][j] = false;
        return t + grid[i][j];
    }
}
