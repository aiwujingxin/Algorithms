package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 00:04
 */
public class LeetCode1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean dfs(int[][] g1, int[][] g2, int r, int c) {
        if (r < 0 || c < 0 || r >= g2.length || c >= g2[0].length || g2[r][c] == 0) {
            return true;
        }
        if (g1[r][c] == 0) {
            return false;
        }
        g2[r][c] = 0; // 标记访问过
        boolean d1 = dfs(g1, g2, r + 1, c);
        boolean d2 = dfs(g1, g2, r - 1, c);
        boolean d3 = dfs(g1, g2, r, c + 1);
        boolean d4 = dfs(g1, g2, r, c - 1);
        return d1 && d2 && d3 && d4;
    }
}
