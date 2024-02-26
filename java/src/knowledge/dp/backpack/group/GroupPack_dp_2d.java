package knowledge.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 11:47
 */
public class GroupPack_dp_2d implements GroupPack {

    public int backPack(int N, int m, int[] C, int[][] V, int[][] W) {
        int[][] dp = new int[N + 1][m + 1];
        for (int k = 1; k <= N; k++) {
            for (int v = 0; v <= m; v++) {
                dp[k][v] = dp[k - 1][v];  //不选
                for (int i = 0; i < C[k - 1]; i++) {
                    if (v >= V[k - 1][i]) {
                        dp[k][v] = Math.max(dp[k][v], dp[k - 1][v - V[k - 1][i]] + W[k - 1][i]);
                    }
                }
            }
        }
        return dp[N][m];
    }
}
