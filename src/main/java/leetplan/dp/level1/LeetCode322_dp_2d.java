package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:21
 */
public class LeetCode322_dp_2d {

    //https://leetcode.com/problems/coin-change/discuss/1091086/Java-1D-and-2D-dp-solution
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        double[][] dp = new double[n + 1][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = Double.POSITIVE_INFINITY;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] > amount ? -1 : (int) dp[n][amount];
    }
}
