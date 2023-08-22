package basicKnowledge.algorithm.dynamicProgramming.knapsack.zeroOne;

import basicKnowledge.algorithm.dynamicProgramming.knapsack.Knapsack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 23:20
 */
public class ZeroOnePack_dp_2d implements Knapsack {

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return dp[n][capacity];
    }
}
