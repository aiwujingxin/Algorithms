package leetcode.lists.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 21:31
 */
public class LeetCode122 {

    public static void main(String[] args) {
        System.out.println(new LeetCode122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            //保持没有 或者 前一天买入的情况下卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //保持有 或者 前一天没有的情况下买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }

        return dp[dp.length - 1][0];
    }
}
