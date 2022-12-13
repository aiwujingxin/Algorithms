package codeTop.ms;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 23:15
 */
public class LeetCode518_dp_1d {

    //https://leetcode.com/problems/coin-change-ii/discuss/1135391/Java-clean-2D1D-DP-Solution-oror-detailed-comments

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
