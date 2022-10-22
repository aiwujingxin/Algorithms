package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 21:58
 */
public class LeetCode64 {

    public static void main(String[] args) {
        System.out.println(new LeetCode64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
