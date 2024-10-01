package knowledge.algorithms.dp.intervaldp.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 19:12
 * @description 矩阵链乘法
 */
public class MatrixChain {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{30, 35}, {35, 15}, {15, 5}, {5, 10}, {10, 20}, {20, 25}};
        int n = matrix.length;
        int[] P = new int[n + 1];
        P[0] = matrix[0][0];
        P[n] = matrix[n - 1][1];
        for (int i = 1; i < n; i++) {
            P[i] = matrix[i][0];
        }
        System.out.println(Arrays.toString(P));
        System.out.println("最小乘法次数: " + new MatrixChain().matrixMultiplication(P));
    }

    public int matrixMultiplication(int[] p) {
        int n = p.length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n]; //划分方法
        for (int len = 2; len < n; len++) {
            System.out.println("规模 " + len + " 时");
            for (int l = 1; l < n - len + 1; l++) { //子问题遍历
                int r = l + len - 1;
                System.out.println("子问题 dp[" + l + "]" + "[" + r + "]");
                f[l][r] = Integer.MAX_VALUE; // 单个子问题的求解(动态性遍历)
                for (int k = l; k < r; k++) {
                    System.out.println("划分点" + "k=" + k + " dp[" + l + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + r + "]" + " +" + " p" + "[" + (l - 1) + "]" + "*" + "p[" + k + "]" + "*" + "p[" + r + "]");
                    int cost = f[l][k] + f[k + 1][r] + p[l - 1] * p[k] * p[r];
                    if (cost < f[l][r]) {
                        g[l][r] = k;
                        f[l][r] = cost;
                    }
                }
            }
        }
        for (int[] a : f) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("分割方案");
        for (int[] a : g) {
            System.out.println(Arrays.toString(a));
        }
        return f[1][n - 1];
    }
}
