package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2022-02-23 12:49 PM
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
        //fix i <= amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    //fix Math.min(dp[i], dp[i - coins[j]] + 1)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[dp.length - 1] > amount ? -1 : dp[dp.length - 1];
    }

}
