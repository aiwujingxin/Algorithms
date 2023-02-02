package leetcode.plan.graph.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 22:40
 */
public class LeetCode695 {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    helper(grid, i, j, list);
                    max = Math.max(max, list.size());
                }
            }
        }
        return max;
    }

    private void helper(int[][] grid, int i, int j, List<Integer> list) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        list.add(1);
        helper(grid, i + 1, j, list);
        helper(grid, i - 1, j, list);
        helper(grid, i, j + 1, list);
        helper(grid, i, j - 1, list);
    }
}
