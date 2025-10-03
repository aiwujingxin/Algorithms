package leetcode.problems;

import knowledge.datastructure.graph.bipartite.impl.KM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 17:54
 * @description 转换思想：最小化成本 = 最大化节省
 * - 找出所有可能的移动成本中的最大值，记为 `max_cost`。
 * - 构建一个新的权重矩阵 `weight`，其中 `weight[i][j] = max_cost - cost[i][j]`。
 * - `cost[i][j]` 是将第 `i` 个多余石头移动到第 `j` 个空格子的成本。
 * - 这个新的 `weight[i][j]` 可以理解为“节省的成本”。成本越小，节省的就越多，权重就越大。
 * - 用这个新的 `weight` 矩阵去求解最大权匹配。
 * - 得到最大权匹配的总和 `max_weight_sum` 后，通过公式 `(n * max_cost) - max_weight_sum` 就可以反推出最小成本总和。
 */
public class LeetCode2850_km {
    public int minimumMoves(int[][] grid) {
        // 步骤 1: 识别二分图的左右顶点
        List<int[]> sources = new ArrayList<>(); // 多余的石头 (左部顶点)
        List<int[]> targets = new ArrayList<>(); // 空格子 (右部顶点)
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (grid[r][c] > 1) {
                    // 如果一个格子里有 k > 1 个石头，就添加 k-1 个源点
                    for (int i = 0; i < grid[r][c] - 1; i++) {
                        sources.add(new int[]{r, c});
                    }
                } else if (grid[r][c] == 0) {
                    // 如果一个格子是空的，就添加一个目标点
                    targets.add(new int[]{r, c});
                }
            }
        }
        // 如果没有需要移动的石头，直接返回 0
        if (sources.isEmpty()) {
            return 0;
        }
        int n = sources.size(); // 多余石头/空格子的数量
        // 步骤 2: 构建成本矩阵 cost[i][j]
        int[][] costMatrix = new int[n][n];
        int maxCost = 0;
        for (int i = 0; i < n; i++) {
            int[] src = sources.get(i);
            for (int j = 0; j < n; j++) {
                int[] tgt = targets.get(j);
                int cost = Math.abs(src[0] - tgt[0]) + Math.abs(src[1] - tgt[1]);
                costMatrix[i][j] = cost;
                maxCost = Math.max(maxCost, cost);
            }
        }
        // 步骤 3: 将最小权问题转换为最大权问题
        int[][] weightMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weightMatrix[i][j] = maxCost - costMatrix[i][j];
            }
        }
        // 步骤 4: 使用 KM 模板求解最大权匹配
        KM km = new KM(weightMatrix);
        int maxWeightSum = km.solve();
        // 步骤 5: 将结果转换回最小成本
        return (n * maxCost) - maxWeightSum;
    }
}
