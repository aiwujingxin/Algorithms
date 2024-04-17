package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/28 23:24
 */
public class LeetCode188 {

    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
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
