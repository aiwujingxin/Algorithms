package knowledge.algorithms.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:54
 * @description 从 矩阵的递推 过程出发，新增的条件实际上只是将 dp[i][j] 的状态依赖限制在了某一段特定的区域之中
 */
public class Multiple_dp_2d implements MultiplePack {

    public int backPack(int[] C, int[] W, int[] S, int V) {
        int N = W.length;
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int v = 1; v <= V; v++) {
                for (int k = 0; k <= S[i - 1] && v >= k * C[i - 1]; k++) {
                    dp[i][v] = Math.max(dp[i][v], dp[i - 1][v - k * C[i - 1]] + k * W[i - 1]);
                }
            }
        }
        return dp[N][V];
    }
}
