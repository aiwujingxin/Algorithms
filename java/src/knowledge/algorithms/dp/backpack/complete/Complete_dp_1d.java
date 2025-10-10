package knowledge.algorithms.dp.backpack.complete;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:33
 * @description Complete空间压缩
 */
public class Complete_dp_1d implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < C.length; i++) {
            for (int v = C[i]; v <= V; v++) {
                dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
            }
        }
        return dp[V];
    }
}
