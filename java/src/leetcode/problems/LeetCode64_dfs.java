package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/17 21:10
 */
public class LeetCode64_dfs {

    //https://leetcode.com/problems/minimum-path-sum/discuss/1190409/JAVA-Best-Recursive-or-Memo-or-Dp-Solution

    static int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        memo = new int[m + 1][n + 1];
        return find(grid, m, n, memo);
    }

    public int find(int[][] grid, int m, int n, int[][] memo) {
        if (m == 0 && n == 0) {

            return grid[0][0];
        }
        if (m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        return memo[m][n] = grid[m][n] + Math.min(find(grid, m - 1, n, memo), find(grid, m, n - 1, memo));
    }
}
