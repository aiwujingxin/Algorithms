package basic.algorithm.dp.knapsack.changeMoney;

import leetcode.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/5 00:27
 * @description 01背包
 * @see LeetCode322_dp_1d
 */
public class CoinChange implements ChangeMoney {

    @Override
    public int change(int amount, int[] coins) {
        // dp[n] = min number of coins to make amount n;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
