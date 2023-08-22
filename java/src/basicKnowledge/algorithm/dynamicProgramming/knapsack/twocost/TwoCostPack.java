package basicKnowledge.algorithm.dynamicProgramming.knapsack.twocost;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:37
 */
public class TwoCostPack {

    public static void main(String[] args) {
        int N = 3; // Number of items
        int[] weights = {2, 3, 4}; // Weights of items
        int[] volumes = {1, 2, 3}; // Volumes of items
        int[] values = {5, 7, 10}; // Values of items
        int W = 5; // Max weight
        int V = 4; // Max volume
        int result = new TwoCostPack().backPack(N, weights, volumes, values, W, V);
        System.out.println("Maximum value: " + result);
    }

    public int backPack(int N, int[] weights, int[] volumes, int[] values, int W, int V) {
        int[][][] dp = new int[N + 1][W + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k <= V; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= weights[i - 1] && k >= volumes[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - weights[i - 1]][k - volumes[i - 1]] + values[i - 1]);
                    }
                }
            }
        }
        return dp[N][W][V];
    }
}
