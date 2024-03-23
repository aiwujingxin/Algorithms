package knowledge.algorithms.dp.backpack.complete;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:35
 */
public class Complete_dfs_memo implements CompletePack {

    int[][] memo;
    int[] weights;
    int[] values;

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int n = C.length;
        this.memo = new int[n + 1][V + 1];
        this.weights = C;
        this.values = W;
        for (int[] row : memo) {
            Arrays.fill(row, -1); // 初始化为-1，表示尚未计算过
        }
        return dfs(n, V);
    }

    private int dfs(int index, int capacity) {
        if (index == 0 || capacity == 0) {
            return 0;
        }

        if (memo[index][capacity] != -1) {
            return memo[index][capacity]; // 如果已经计算过，直接返回缓存的结果
        }

        if (weights[index - 1] <= capacity) {
            // 考虑将当前物品放入背包多次的情况
            int take = values[index - 1] + dfs(index, capacity - weights[index - 1]);
            // 考虑不放入当前物品的情况
            int notTake = dfs(index - 1, capacity);
            memo[index][capacity] = Math.max(take, notTake);
        } else {
            // 当前物品的重量超过了背包容量，不能放入
            memo[index][capacity] = dfs(index - 1, capacity);
        }
        return memo[index][capacity];
    }
}
