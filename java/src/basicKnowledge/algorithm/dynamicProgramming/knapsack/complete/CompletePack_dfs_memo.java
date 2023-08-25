package basicKnowledge.algorithm.dynamicProgramming.knapsack.complete;

import basicKnowledge.algorithm.dynamicProgramming.knapsack.Knapsack;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:35
 */
public class CompletePack_dfs_memo implements Knapsack {

    int[][] memo;
    int[] weights;
    int[] values;
    int n;

    @Override
    public int backPack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        memo = new int[n + 1][capacity + 1];
        this.weights = weights;
        this.values = values;
        this.n = capacity;
        for (int[] row : memo) {
            Arrays.fill(row, -1); // 初始化为-1，表示尚未计算过
        }
        return dfs(capacity, n);
    }

    private int dfs(int capacity, int index) {
        if (index == 0 || capacity == 0) {
            return 0;
        }

        if (memo[index][capacity] != -1) {
            return memo[index][capacity]; // 如果已经计算过，直接返回缓存的结果
        }

        if (weights[index - 1] <= capacity) {
            // 考虑将当前物品放入背包多次的情况
            int take = values[index - 1] + dfs(capacity - weights[index - 1], index);
            // 考虑不放入当前物品的情况
            int notTake = dfs(capacity, index - 1);
            memo[index][capacity] = Math.max(take, notTake);
        } else {
            // 当前物品的重量超过了背包容量，不能放入
            memo[index][capacity] = dfs(capacity, index - 1);
        }
        return memo[index][capacity];
    }
}
