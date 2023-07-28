package basic.algorithm.dp.backpack.completePack;

import basic.problems.dp.BackPack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:33
 */
public class CompletePack_dp_1d implements BackPack {

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        // 计算每个容量下的最大价值
        for (int i = 0; i <= capacity; i++) {
            for (int j = 0; j < n; j++) {
                if (weights[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - weights[j]] + values[j]);
                }
            }
        }
        return dp[capacity];
    }
}
