package knowledge.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:54
 * @description 从 矩阵的递推 过程出发，新增的条件实际上只是将 dp[i][j] 的状态依赖限制在了某一段特定的区域之中
 */
public class Multiple_dp_2d implements MultiplePack {

    public int backPack(int[] weights, int[] values, int[] counts, int capacity) {
        int n = values.length;
        int[][] dp = new int[n + 1][capacity + 1];
        // i 是阶段 i和j共同组成“状态”, k 用来做决策
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= counts[i - 1]; k++) {
                    if (j >= k * weights[i - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weights[i - 1]] + k * values[i - 1]);
                    }
                }
            }
        }
        return dp[n][capacity];
    }
}
