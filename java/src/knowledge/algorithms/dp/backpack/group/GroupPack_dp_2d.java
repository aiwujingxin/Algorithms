package knowledge.algorithms.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 11:47
 */
public class GroupPack_dp_2d implements GroupPack {

    public int backPack(int N, int m, int[] K, int[][] C, int[][] W) {
        int[][] dp = new int[N + 1][m + 1];
        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= m; v++) {
                dp[i][v] = dp[i - 1][v];  //不选
                for (int k = 0; k < K[i - 1]; k++) {
                    if (v >= C[i - 1][k]) {
                        dp[i][v] = Math.max(dp[i][v], dp[i - 1][v - C[i - 1][k]] + W[i - 1][k]);
                    }
                }
            }
        }
        return dp[N][m];
    }
}
