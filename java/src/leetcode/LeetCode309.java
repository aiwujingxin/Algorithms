package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-12 3:45 PM
 */
public class LeetCode309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        //不持有
        dp[0][0] = 0;
        //持有
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i]; // 卖出
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][2]);
    }
}
