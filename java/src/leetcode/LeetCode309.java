package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 23:02
 */
public class LeetCode309 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;// 不持有
        dp[0][1] = -prices[0];// 持有
        dp[0][2] = 0;// 冻结期
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][2]);
    }
}
