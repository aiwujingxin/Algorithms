package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 13:28
 */
public class LeetCode322 {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[dp.length - 1] == max ? -1 : dp[dp.length - 1];
    }
}
