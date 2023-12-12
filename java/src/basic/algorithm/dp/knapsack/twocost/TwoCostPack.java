package basic.algorithm.dp.knapsack.twocost;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:37
 */
public class TwoCostPack {

    public static void main(String[] args) {
        int N = 15; // Number of items
        int V = 20; // Max volume
        int W = 15; // Max weight
        int[] volumes = {1, 2, 3, 4, 2, 1, 5, 1, 1, 2, 1, 2, 5, 2, 1}; // Volumes of items
        int[] weights = {2, 4, 4, 5, 3, 2, 4, 5, 3, 2, 2, 3, 6, 3, 3}; // Weights of items
        int[] values = {3, 4, 5, 6, 4, 3, 3, 2, 5, 2, 4, 5, 2, 5, 7}; // Values of items
        int[] values1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // Values of items
        System.out.println(new TwoCostPack().backPack(N, V, W, volumes, weights, values));
        System.out.println(new TwoCostPack().backPack(N, V, W, volumes, weights, values1));
    }

    List<Integer> result = new ArrayList<>();

    public int backPack(int N, int V, int W, int[] volumes, int[] weights, int[] values) {
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
        int volume = V;
        int weight = W;
        for (int i = N; i >= 1; i--) {
            if (dp[i][weight][volume] != dp[i - 1][weight][volume]) {
                result.add(i - 1);
                volume -= volumes[i - 1];
                weight -= weights[i - 1];
            }
        }
        for (Integer index : result) {
            System.out.println("选择物品 " + index + ",它的价值" + values[index] + ".");
        }
        System.out.println("最大价值 " + dp[N][W][V]);
        return dp[N][W][V];
    }

    // 空间优化
    public int backPack_2d(int N, int V, int M, int[] volumes, int[] weights, int[] values) {
        int[][] dp = new int[V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= volumes[i - 1]; j--) {
                for (int k = M; k >= weights[i - 1]; k--) {
                    dp[j][k] = Math.max(dp[j - volumes[i - 1]][k - weights[i - 1]] + values[i - 1], dp[j][k]);
                }
            }
        }
        return dp[V][M];
    }
}
