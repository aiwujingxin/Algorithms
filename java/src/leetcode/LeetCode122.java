package leetcode;

/**
 * @author jingxinwu
 * @date 2021-12-07 12:36 上午
 */
public class LeetCode122 {


    //dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
    //dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int n = prices.length;
        int[][] dp = new int[n][2];

        //表示第 i 天交易完后手里没有股票的最大利润
        dp[0][0] = 0;
        //表示第 i 天交易完后手里有股票的最大利润
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; ++i) {
            // 保持没有，或者卖出前一天的股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 保持有，或者有该天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[dp.length - 1][0];
    }

}
