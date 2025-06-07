package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/4/25 01:44
 */
public class MatrixChain_dfs implements MatrixChain {

    public int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return matrixChainOrder(p, 1, n - 1, memo);
    }

    private int matrixChainOrder(int[] p, int i, int j, int[][] memo) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i == j) return memo[i][j] = 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int count = matrixChainOrder(p, i, k, memo) + matrixChainOrder(p, k + 1, j, memo) + p[i - 1] * p[k] * p[j];
            if (count < min) {
                min = count;
            }
        }
        return memo[i][j] = min;
    }
}
