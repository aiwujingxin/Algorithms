package leetcode.plan.graph.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 23:14
 */
public class LeetCode1020 {

    public int numEnclaves(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)) {
                    helper(grid, i, j, new ArrayList<>());
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    helper(grid, i, j, list);
                    res = res + list.size();
                }
            }
        }
        return res;
    }

    private void helper(int[][] grid, int i, int j, List<Integer> list) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        list.add(1);
        helper(grid, i + 1, j, list);
        helper(grid, i, j + 1, list);
        helper(grid, i - 1, j, list);
        helper(grid, i, j - 1, list);
    }
}
