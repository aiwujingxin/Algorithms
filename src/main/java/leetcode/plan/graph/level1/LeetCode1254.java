package leetcode.plan.graph.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 22:48
 */
public class LeetCode1254 {


    public int closedIsland(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        //first
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)) {
                    dfs(grid, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
