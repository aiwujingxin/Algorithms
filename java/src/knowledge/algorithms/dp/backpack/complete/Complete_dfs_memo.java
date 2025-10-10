package knowledge.algorithms.dp.backpack.complete;


import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 12:35
 */
public class Complete_dfs_memo implements CompletePack {

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
        if (memo[i][j] != -1) return memo[i][j];
        if (j < C[i]) return memo[i][j] = dfs(i - 1, j);
        return memo[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - C[i]) + W[i]);
    }
}
