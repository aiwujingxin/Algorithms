package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:39
 */
public class LeetCode121_dp_2d {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][2];

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数
        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //fix dp[0][0] - prices[i]
            //  - prices[i]这里可以理解为dp[0][0] - prices[i]，这里为什么是dp[0][0] - prices[i]，因为只有这样才能保证只买一次，所以需要用一开始初始化的未持股的现金dp[0][0]减去当天的股价
            dp[i][1] = Math.max(dp[i - 1][1], dp[0][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
