package knowledge.algorithms.dp.backpack.group;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 4/7/25 01:42
 */
public class GroupPack_dp_3d implements GroupPack {

    public int backPack(int N, int V, int[] K, int[][] costs, int[][] values) {
        // dp[i][j][k]，i∈[0,N]，j∈[0,V]，k∈[0,K[i]]
        int[][][] dp = new int[N + 1][V + 1][];

        // 初始化三维数组
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = new int[(i == 0) ? 1 : K[i - 1] + 1];
                Arrays.fill(dp[i][j], -1);  // -1表示不可达状态
            }
        }

        // 初始状态：0组物品，0容量，价值0
        dp[0][0][0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                // 不选当前组任何物品
                for (int k = 0; k < dp[i - 1][j].length; k++) {
                    if (dp[i - 1][j][k] != -1) {
                        dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][k]);
                    }
                }

                // 选择当前组的某个物品
                for (int k = 1; k <= K[i - 1]; k++) {
                    int cost = costs[i - 1][k - 1];
                    int value = values[i - 1][k - 1];

                    if (j >= cost) {
                        for (int kPrev = 0; kPrev < dp[i - 1][j - cost].length; kPrev++) {
                            if (dp[i - 1][j - cost][kPrev] != -1) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - cost][kPrev] + value);
                            }
                        }
                    }
                }
            }
        }

        // 找出最大值
        int max = 0;
        for (int j = 0; j <= V; j++) {
            for (int k = 0; k < dp[N][j].length; k++) {
                max = Math.max(max, dp[N][j][k]);
            }
        }
        return max;
    }
}
