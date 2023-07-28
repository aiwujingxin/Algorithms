package basic.algorithm.dp.backpack.multiplePack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:54
 */
public class MultiplePack {

    public static int multipleKnapsack(int capacity, int[] weights, int[] values, int[] counts) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        // 计算每个容量下的最大价值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                for (int k = 0; k <= counts[i - 1] && k * weights[i - 1] <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * weights[i - 1]] + k * values[i - 1]);
                }
            }
        }
        return dp[n][capacity];
    }
}
