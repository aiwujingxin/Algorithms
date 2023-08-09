package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-08-13 2:29 上午
 */
public class LeetCode695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(grid, i, j, list);
                    res = Math.max(list.size(), res);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j, ArrayList<Integer> list) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        list.add(0);
        grid[i][j] = 0;
        dfs(grid, i + 1, j, list);
        dfs(grid, i - 1, j, list);
        dfs(grid, i, j - 1, list);
        dfs(grid, i, j + 1, list);
    }

}
