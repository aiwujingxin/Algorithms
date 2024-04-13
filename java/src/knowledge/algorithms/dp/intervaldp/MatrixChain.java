package knowledge.algorithms.dp.intervaldp;

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
        int[][] dp = new int[n][n];
        int[][] s = new int[n][n]; //划分方法
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int r = 2; r < n; r++) {
            System.out.println("规模 " + r + " 时");
            for (int i = 1; i < n - r + 1; i++) { //子问题遍历
                int j = i + r - 1;
                System.out.println("子问题 dp[" + i + "]" + "[" + j + "]");
                dp[i][j] = Integer.MAX_VALUE; // 单个子问题的求解(动态性遍历)
                for (int k = i; k < j; k++) {
                    System.out.println("划分点" + "k=" + k + " dp[" + i + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + j + "]" + " +" + " p" + "[" + (i - 1) + "]" + "*" + "p[" + k + "]" + "*" + "p[" + j + "]");
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        s[i][j] = k;
                        dp[i][j] = cost;
                    }
                }
            }
        }
        for (int[] d : dp) {
            System.out.println(Arrays.toString(d));
        }
        System.out.println("分割方案");
        for (int[] d : s) {
            System.out.println(Arrays.toString(d));
        }
        return dp[1][n - 1];
    }
}
