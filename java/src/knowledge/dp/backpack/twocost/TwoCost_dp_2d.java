package knowledge.dp.backpack.twocost;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/27 16:32
 */
public class TwoCost_dp_2d implements TwoCostPack {

    public int backPack(int N, int V, int W, int[] volumes, int[] weights, int[] values) {
        int[][] dp = new int[V + 1][W + 1];
        TreePosition[][] dpTree = new TreePosition[V + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int v = V; v >= volumes[i - 1]; v--) {
                for (int k = W; k >= weights[i - 1]; k--) {
                    if (dp[v][k] < dp[v - volumes[i - 1]][k - weights[i - 1]] + values[i - 1]) {
                        dp[v][k] = dp[v - volumes[i - 1]][k - weights[i - 1]] + values[i - 1];
                        dpTree[v][k] = new TreePosition(i, dpTree[v - volumes[i - 1]][k - weights[i - 1]]);
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        TreePosition treePosition = dpTree[V][W];
        while (treePosition != null) {
            result.add(treePosition.number - 1);
            treePosition = treePosition.parentNode;
        }
        for (Integer index : result) {
            System.out.println("选择物品 " + index + ",它的价值" + values[index] + ".");
        }
        System.out.println("最大价值 " + dp[V][W]);
        return dp[V][W];
    }

    static class TreePosition {
        int number;
        TreePosition parentNode;

        public TreePosition(int number, TreePosition parentNode) {
            this.number = number;
            this.parentNode = parentNode;
        }
    }
}
