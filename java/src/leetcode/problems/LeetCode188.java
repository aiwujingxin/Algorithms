package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/11/28 23:24
 */
public class LeetCode188 {

    public int maxProfit(int K, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        K = Math.min(K, n / 2);
        int[][] hold = new int[n][K + 1];
        int[][] sold = new int[n][K + 1];

        hold[0][0] = -prices[0];
        sold[0][0] = 0;
        for (int i = 1; i <= K; ++i) {
            hold[0][i] = sold[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i < n; i++) {
            hold[i][0] = Math.max(hold[i - 1][0], sold[i - 1][0] - prices[i]);
        }
        for (int i = 1; i < n; i++) {
            for (int k = 1; k <= K; k++) {
                hold[i][k] = Math.max(hold[i - 1][k], sold[i - 1][k] - prices[i]);
                sold[i][k] = Math.max(sold[i - 1][k], hold[i - 1][k - 1] + prices[i]);
            }
        }
        int max = 0;
        for (int k = 0; k < K; k++) {
            max = Math.max(sold[n - 1][k], max);
        }
        return max;
    }

    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/1007170/Java-Recursive-greater-Memoization-greater-3D-Bottom-Up-greater-2D-Bottom-Up
    public int maxProfit_3d(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            for (int state = 1; state >= 0; state--) {
                for (int j = 1; j <= k; j++) {
                    dp[i][state][j] = (state == 0) ?
                            Math.max(dp[i + 1][1][j] - prices[i], dp[i + 1][state][j]) :
                            Math.max(dp[i + 1][0][j - 1] + prices[i], dp[i + 1][state][j]);
                }
            }
        }
        return dp[0][0][k];
    }
}
