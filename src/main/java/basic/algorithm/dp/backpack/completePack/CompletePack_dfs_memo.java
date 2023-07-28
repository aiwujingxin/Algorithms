package basic.algorithm.dp.backpack.completePack;

import basic.problems.dp.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:35
 */
public class CompletePack_dfs_memo implements BackPack {

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        int n = weights.length;
        int[][] memo = new int[n + 1][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // 初始化为-1，表示尚未计算过
        }
        return knapsackHelper(weights, values, capacity, n, memo);
    }

    private static int knapsackHelper(int[] weights, int[] values, int capacity, int index, int[][] memo) {
        if (index == 0 || capacity == 0) {
            return 0;
        }

        if (memo[index][capacity] != -1) {
            return memo[index][capacity]; // 如果已经计算过，直接返回缓存的结果
        }

        if (weights[index - 1] <= capacity) {
            // 考虑将当前物品放入背包多次的情况
            int take = values[index - 1] + knapsackHelper(weights, values, capacity - weights[index - 1], index, memo);
            // 考虑不放入当前物品的情况
            int notTake = knapsackHelper(weights, values, capacity, index - 1, memo);
            memo[index][capacity] = Math.max(take, notTake);
        } else {
            // 当前物品的重量超过了背包容量，不能放入
            memo[index][capacity] = knapsackHelper(weights, values, capacity, index - 1, memo);
        }
        return memo[index][capacity];
    }
}
