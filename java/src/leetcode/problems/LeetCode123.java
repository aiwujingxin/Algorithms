package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 22:37
 */
public class LeetCode123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int K = 2;
        int[][][] dp = new int[n + 1][K + 1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= K; k++) {
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i - 1]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][K][0];
    }
}
