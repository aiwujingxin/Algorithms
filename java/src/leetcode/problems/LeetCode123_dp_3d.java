package leetcode.problems;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/7 22:29
 * {@link LeetCode188_dp_3d}
 */
public class LeetCode123_dp_3d {

    /**
     * dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
     * dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
     * k交易次数上限
     * <p>
     * 可扩展至第188题 的解法
     */

    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][3][2];
        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][2][0];
    }
}
