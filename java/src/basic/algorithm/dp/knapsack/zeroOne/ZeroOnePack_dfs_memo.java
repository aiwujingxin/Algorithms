package basic.algorithm.dp.knapsack.zeroOne;

import basic.algorithm.dp.knapsack.knapsack;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:37
 */
public class ZeroOnePack_dfs_memo implements knapsack {

    int n;
    int[][] memo;
    int capacity;
    int[] weights;
    int[] values;

    public static void main(String[] args) {
    }

    @Override
    public int backPack(int capacity, int[] weights, int[] values) {
        n = weights.length;
        memo = new int[n + 1][capacity + 1];
        this.capacity = capacity;
        this.weights = weights;
        this.values = values;
        for (int[] row : memo) {
            Arrays.fill(row, -1); // 初始化为-1，表示尚未计算过
        }
        return rec(0, capacity);
    }

    private int rec(int i, int j) {
        if (memo[i][j] > 0) {
            return memo[i][j]; // 如果已经计算过，直接返回缓存的结果
        }
        if (i == n) {
            memo[i][j] = 0;
        } else if (j < weights[i]) {
            // 当前物品的重量超过了背包容量，不能放入
            memo[i][j] = rec(i + 1, j);
        } else {
            memo[i][j] = Math.max(rec(i + 1, j), rec(i + 1, j - weights[i]) + values[i]);
        }
        return memo[i][j];
    }
}
