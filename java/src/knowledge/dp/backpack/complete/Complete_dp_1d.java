package knowledge.dp.backpack.complete;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:33
 */
public class Complete_dp_1d implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int v = C[i]; v <= V; v++) {
                dp[v] = Math.max(dp[v], dp[v - C[i]] + W[i]);
            }
        }
        return dp[V];
    }
}
