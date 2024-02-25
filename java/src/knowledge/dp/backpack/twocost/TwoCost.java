package knowledge.dp.backpack.twocost;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:37
 * @description 二维费用背包
 */
public class TwoCost {

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


    static class TreePosition {
        int number;
        TreePosition parentNode;

        public TreePosition(int number, TreePosition parentNode) {
            this.number = number;
            this.parentNode = parentNode;
        }
    }

    // 空间优化
    public int backPack_2d(int N, int V, int M, int[] volumes, int[] weights, int[] values) {
        int[][] dp = new int[V + 1][M + 1];
        TreePosition[][] dpTree = new TreePosition[V + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= volumes[i - 1]; j--) {
                for (int k = M; k >= weights[i - 1]; k--) {
                    if (dp[j - volumes[i - 1]][k - weights[i - 1]] + values[i - 1] > dp[j][k]) {
                        dp[j][k] = dp[j - volumes[i - 1]][k - weights[i - 1]] + values[i - 1];
                        dpTree[j][k] = new TreePosition(i, dpTree[j - volumes[i - 1]][k - weights[i - 1]]);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        TreePosition treePosition = dpTree[V][M];
        while (treePosition != null) {
            result.add(treePosition.number - 1);
            treePosition = treePosition.parentNode;
        }
        for (Integer index : result) {
            System.out.println("选择物品 " + index + ",它的价值" + values[index] + ".");
        }
        System.out.println("最大价值 " + dp[V][M]);
        return dp[V][M];
    }
}
