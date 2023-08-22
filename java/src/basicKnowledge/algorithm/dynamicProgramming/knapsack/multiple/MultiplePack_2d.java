package basicKnowledge.algorithm.dynamicProgramming.knapsack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:54
 */
public class MultiplePack_2d {

    public int backPack(int capacity, int[] weight, int[] values, int[] amounts) {
        int n = values.length;
        // dp[i][j]: first ith prices, using j money, maximum weight
        int[][] dp = new int[n + 1][capacity + 1];
        dp[0][0] = 0;
        // i 是阶段 i和j共同组成“状态”, k 用来做决策
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= amounts[i - 1]; k++) {
                    if (j >= k * weight[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weight[i - 1]] + k * values[i - 1]);
                    }
                }
            }
        }
        return dp[n][capacity];
    }
}
