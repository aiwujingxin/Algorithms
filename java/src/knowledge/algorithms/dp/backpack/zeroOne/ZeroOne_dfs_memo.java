package knowledge.algorithms.dp.backpack.zeroOne;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:37
 */
public class ZeroOne_dfs_memo implements ZeroOnePack {

    int n;
    int[][] memo;
    int V;
    int[] C;
    int[] W;

    @Override
    public int backPack(int[] C, int[] W, int V) {
        n = C.length;
        memo = new int[n][V + 1];
        this.V = V;
        this.C = C;
        this.W = W;
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, V);
    }

    private int dfs(int i, int j) {
        if (i >= n || j <= 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int maxValue;
        if (C[i] > j) {
            maxValue = dfs(i + 1, j);
        } else {
            maxValue = Math.max(dfs(i + 1, j - C[i]) + W[i], dfs(i + 1, j));
        }
        memo[i][j] = maxValue;
        return maxValue;
    }
}
