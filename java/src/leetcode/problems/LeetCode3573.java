package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/17/25 14:53
 */
public class LeetCode3573 {


    public static void main(String[] args) {
        System.out.println(new LeetCode3573().maximumProfit(new int[]{1, 7, 9, 8, 2}, 2));
    }

    public long maximumProfit(int[] prices, int K) {
        int n = prices.length;
        long[][] dp = new long[K + 1][4];
        for (int k = 0; k <= K; k++) {
            dp[k][1] = Integer.MIN_VALUE;
            dp[k][3] = Integer.MIN_VALUE;

        }
        // 1 普通买入 基于 上一轮   的 普通卖出  或者 做空买入
        // 0 普通卖出 基于 本轮     的 普通买入

        // 2 做空卖出 基于 上一轮   的 普通卖出 或者 做空买入
        // 3 做空买入 基于  本轮   的  做空卖出
        for (int i = 1; i <= n; i++) {
            for (int k = K; k >= 1; k--) {
                dp[k][1] = Math.max(dp[k][1], Math.max(dp[k - 1][0], dp[k - 1][3]) - prices[i - 1]);
                dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[i - 1]);
                dp[k][2] = Math.max(dp[k][2], Math.max(dp[k - 1][0], dp[k - 1][3]) + prices[i - 1]);
                dp[k][3] = Math.max(dp[k][3], dp[k][2] - prices[i - 1]);
            }
        }
        return Math.max(dp[K][0], dp[K][3]);
    }
}
