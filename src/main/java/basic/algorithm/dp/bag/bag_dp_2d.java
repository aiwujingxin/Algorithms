package basic.algorithm.dp.bag;

import basic.problems.dp.BackPack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 23:20
 * <a href="https://www.lintcode.com/problem/125/"></a>
 */
public class bag_dp_2d implements BackPack {

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][capacity];
    }

}
