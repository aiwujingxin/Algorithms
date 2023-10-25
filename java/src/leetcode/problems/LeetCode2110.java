package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/25 23:05
 */
public class LeetCode2110 {

    public long getDescentPeriods(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        long[] dp = new long[prices.length];
        dp[0] = 1;
        long res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] == prices[i] + 1) {
                dp[i] += dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res += dp[i];
        }
        return res;
    }
}
