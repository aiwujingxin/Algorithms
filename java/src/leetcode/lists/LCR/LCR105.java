package leetcode.lists.LCR;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 14:21
 */
public class LCR105 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs(grid, i, j, list);
                    res = Math.max(res, list.size());
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, List<Integer> list) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return;
        }
        list.add(1);
        grid[i][j] = 0;
        dfs(grid, i + 1, j, list);
        dfs(grid, i, j + 1, list);
        dfs(grid, i - 1, j, list);
        dfs(grid, i, j - 1, list);
    }
}
