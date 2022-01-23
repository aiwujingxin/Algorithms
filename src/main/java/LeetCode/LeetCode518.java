package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-12-26 9:58 PM
 */
public class LeetCode518 {

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
