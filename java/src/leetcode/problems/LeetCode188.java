package leetcode.problems;

import java.util.Arrays;

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

    public int maxProfit_2d(int K, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[K + 1][2];
        for (int k = 0; k <= K; k++) {
            dp[k][1] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            for (int k = K; k >= 1; k--) {
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + price);
                dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - price);
            }
        }
        return dp[K][0];
    }
}
