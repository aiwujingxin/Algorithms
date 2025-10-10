package knowledge.algorithms.dp.backpack.zeroOne;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:37
 */
public class ZeroOne_dfs_memo implements ZeroOnePack {

    private int[][] memo;
    private int[] C, W;

    @Override
    public int backPack(int[] C, int[] W, int V) {
        this.C = C;
        this.W = W;
        memo = new int[C.length + 1][V + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(C.length - 1, V);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j <= 0) return 0;
        if (memo[i + 1][j] != -1) return memo[i + 1][j];
        if (j < C[i]) return memo[i + 1][j] = dfs(i - 1, j);
        return memo[i + 1][j] = Math.max(dfs(i - 1, j), dfs(i - 1, j - C[i]) + W[i]);
    }
}
