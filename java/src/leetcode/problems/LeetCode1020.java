package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/30 13:38
 */
public class LeetCode1020 {

    public int numEnclaves(int[][] grid) {
        // 两次 dfs
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && grid[i][j] == 1) {
                    dfs(grid, i, 0, 2);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs2(grid, i, j, list);
                    cnt += list.size();
                }

            }
        }
        return cnt;
    }

    private void dfs2(int[][] grid, int i, int j, List<Integer> list) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return;
        }
        list.add(1);
        grid[i][j] = 2;
        dfs2(grid, i + 1, j, list);
        dfs2(grid, i, j + 1, list);
        dfs2(grid, i - 1, j, list);
        dfs2(grid, i, j - 1, list);
    }

    private void dfs(int[][] grid, int i, int j, int flag) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 2 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i + 1, j, flag);
        dfs(grid, i, j + 1, flag);
        dfs(grid, i - 1, j, flag);
        dfs(grid, i, j - 1, flag);
    }
}
