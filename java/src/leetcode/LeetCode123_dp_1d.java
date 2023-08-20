package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 22:23
 */
public class LeetCode123_dp_1d {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[3] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return dp[4];
    }
}
