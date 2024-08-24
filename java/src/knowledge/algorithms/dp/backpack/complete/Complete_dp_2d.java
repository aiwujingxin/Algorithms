package knowledge.algorithms.dp.backpack.complete;


/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:33
 */
public class Complete_dp_2d implements CompletePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int v = 1; v <= V; v++) {
                dp[i][v] = dp[i - 1][v];
                if (v >= C[i - 1]) {
                    dp[i][v] = Math.max(dp[i][v], dp[i][v - C[i - 1]] + W[i - 1]);
                }
            }
        }
        return dp[N][V];
    }
}
