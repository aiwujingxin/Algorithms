package leetcode.lists.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 22:32
 */
public class LeetCode309 {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        // 0 手上有股票
        // 1 手上没有股票
        // 2 手上没有股票，且在冷冻期
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] - prices[i], dp[i - 1][0]);
            //fix
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            //fix
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        //fix
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }
}
