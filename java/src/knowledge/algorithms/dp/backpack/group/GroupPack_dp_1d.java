package knowledge.algorithms.dp.backpack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 10:34
 * @description 空间优化
 */
public class GroupPack_dp_1d implements GroupPack {

    public int backPack(int N, int m, int[] C, int[][] V, int[][] W) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < N; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = 0; k < C[i]; k++) {
                    if (j >= V[i][k]) {
                        dp[j] = Math.max(dp[j], dp[j - V[i][k]] + W[i][k]);
                    }
                }
            }
        }
        return dp[m];
    }
}
