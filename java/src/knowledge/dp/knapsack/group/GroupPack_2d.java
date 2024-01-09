package knowledge.dp.knapsack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 11:47
 */
public class GroupPack_2d implements Problems {

    public int groupKnapsack(int n, int m, int[] groupSizes, int[][] values, int[][] weights) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];  //不选
                for (int k = 0; k < groupSizes[i - 1]; k++) {
                    if (j >= weights[i - 1][k]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weights[i - 1][k]] + values[i - 1][k]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
