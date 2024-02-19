package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 00:06
 * @link <a href="https://aaronice.gitbook.io/lintcode/knapsack_problems/coin-change">...</a>
 */
public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
