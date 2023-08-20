package leetcode;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/7 19:14
 */
public class LeetCode123_dp_2d {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[][] dp = new int[prices.length][5];
        /*
          0: 不买也不卖
          1: 第一次买入
          2: 第一次卖出
          3: 第二次买入
          4: 第二次卖出
        *
        **/
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[dp.length - 1][4];
    }
}
