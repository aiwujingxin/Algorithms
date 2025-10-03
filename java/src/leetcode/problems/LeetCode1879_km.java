package leetcode.problems;

import knowledge.datastructure.graph.bipartite.impl.KM;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 15:54
 */
public class LeetCode1879_km {

    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // --- 步骤 1: 构建成本矩阵并找到最大成本 C_max ---
        int[][] cost = new int[n][n];
        int cMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = nums1[i] ^ nums2[j];
                cMax = Math.max(cMax, cost[i][j]);
            }
        }
        // --- 步骤 2: 构建用于 KM 算法的权重矩阵 ---
        // weight[i][j] = cMax - cost[i][j]
        int[][] weight = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                weight[i][j] = cMax - cost[i][j];
            }
        }
        // --- 步骤 3: 使用 KM 算法求解最大权匹配 ---
        KM kmSolver = new KM(weight);
        int maxWeightSum = kmSolver.solve();
        // --- 步骤 4: 将最大权和转换回最小成本和 ---
        // MinCostSum = n * cMax - MaxWeightSum
        return n * cMax - maxWeightSum;
    }
}
