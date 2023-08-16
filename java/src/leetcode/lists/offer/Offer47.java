package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-23 7:39 下午
 */
public class Offer47 {


    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] += grid[i - 1][j];
                } else {
                    dp[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }

        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}
