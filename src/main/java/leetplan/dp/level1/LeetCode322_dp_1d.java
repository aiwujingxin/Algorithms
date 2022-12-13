package leetplan.dp.level1;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/24 22:15
 */
public class LeetCode322_dp_1d {

    public static void main(String[] args) {
        System.out.println(new LeetCode322_dp_1d().coinChange(new int[]{1, 2, 5}, 11));
    }

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
                    //我们通过局部最优子结构的性质重复使用了之前的枚举过程，优化了枚举的复杂度。
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[dp.length - 1] > amount ? -1 : dp[dp.length - 1];
    }
}
