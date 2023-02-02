package leetcode.plan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/11 20:04
 */
public class LeetCode122 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        //不持有
        dp[0][0] = 0;

        //持有
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //继续不持有， 或者前一天持有的情况下卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //保持持有， 或者前一天不持有的情况下买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[dp.length - 1][0];
    }
}
