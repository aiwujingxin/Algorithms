package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 12/18/25 11:08
 */
public class LeetCode3652 {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] presum = new long[n + 1];
        long[] addSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            presum[i] = presum[i - 1] + ((long) prices[i - 1] * strategy[i - 1]);
            addSum[i] = addSum[i - 1] + prices[i - 1];
        }
        long ans = Long.MIN_VALUE;
        for (int i = k - 1; i < n; i++) {
            long origin = presum[i + 1] - presum[i - k + 1];
            long sell = addSum[i + 1] - addSum[i - k / 2 + 1];
            ans = Math.max(ans, presum[n] - origin + sell);
        }
        return Math.max(ans, presum[n]);
    }
}
