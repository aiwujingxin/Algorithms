package basicKnowledge.algorithm.dynamicProgramming.knapsack.group;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/4 10:34
 */
public class GroupPack_1d {

    public int groupKnapsack(int n, int V, int[] groupSizes, int[][] values, int[][] weights) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= n; i++) {
            for (int v = V; v >= 0; v--) {
                for (int j = 0; j < groupSizes[i - 1]; j++) {
                    if (v >= weights[i - 1][j]) {
                        dp[v] = Math.max(dp[v], dp[v - weights[i - 1][j]] + values[i - 1][j]);
                    }
                }
            }
        }
        return dp[V];
    }
}
