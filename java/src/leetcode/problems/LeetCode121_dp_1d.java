package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 21:39
 */
public class LeetCode121_dp_1d {


    /*
        说明：空间优化只看状态转移方程。
        状态转移方程里下标为 i 的行只参考下标为 i - 1 的行（即只参考上一行），并且：
        下标为 i 的行并且状态为 0 的行参考了上一行状态为 0 和 1 的行；
        下标为 i 的行并且状态为 1 的行只参考了上一行状态为 1 的行。
      */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }
}
