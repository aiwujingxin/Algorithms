package knowledge.algorithms.dp.backpack.multiple;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 23:59
 * @description 转化为01背包。 则需要从大到小
 */
public class Multiple_dp_1d implements MultiplePack {

    public int backPack(int[] C, int[] W, int[] S, int V) {
        int N = W.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int v = V; v >= 0; v--) {
                // k 做决策
                for (int k = 0; k <= S[i] && v >= k * C[i]; k++) {
                    dp[v] = Math.max(dp[v], dp[v - k * C[i]] + k * W[i]);
                }
            }
        }
        return dp[V];
    }
}
