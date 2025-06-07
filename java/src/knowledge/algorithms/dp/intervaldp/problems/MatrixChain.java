package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/4/25 01:44
 */
public interface MatrixChain {

    int matrixChainOrder(int[] p);

    static void main(String[] args) {
        int[][] matrix = new int[][]{{30, 35}, {35, 15}, {15, 5}, {5, 10}, {10, 20}, {20, 25}};
        int n = matrix.length;
        int[] p = new int[n + 1];
        p[0] = matrix[0][0];
        p[n] = matrix[n - 1][1];
        for (int i = 1; i < n; i++) {
            p[i] = matrix[i][0];
        }
        System.out.println(Arrays.toString(p));
        System.out.println("最小乘法次数: " + new MatrixChain_dfs().matrixChainOrder(p));
        System.out.println("最小乘法次数: " + new MatrixChain_dp_v1().matrixChainOrder(p));
        System.out.println("最小乘法次数: " + new MatrixChain_dp_v2().matrixChainOrder(p));
    }
}
