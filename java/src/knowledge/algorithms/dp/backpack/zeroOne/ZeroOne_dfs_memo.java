package knowledge.algorithms.dp.backpack.zeroOne;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:37
 */
public class ZeroOne_dfs_memo implements ZeroOnePack {

    int n;
    int[][] memo;
    int capacity;
    int[] weights;
    int[] values;

    @Override
    public int backPack(int[] C, int[] W, int V) {
        n = C.length;
        memo = new int[n][V + 1];
        this.capacity = V;
        this.weights = C;
        this.values = W;
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, V);
    }

    private int dfs(int index, int capacity) {
        if (index >= weights.length || capacity <= 0) {
            return 0;
        }
        if (memo[index][capacity] != -1) {
            return memo[index][capacity];
        }
        int maxValue;
        if (weights[index] > capacity) {
            maxValue = dfs(index + 1, capacity);
        } else {
            int take = values[index] + dfs(index + 1, capacity - weights[index]);
            int noTake = dfs(index + 1, capacity);
            maxValue = Math.max(take, noTake);
        }
        memo[index][capacity] = maxValue;
        return maxValue;
    }
}
