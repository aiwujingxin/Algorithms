package knowledge.algorithms.dp.intervaldp.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/13 19:12
 * @description 矩阵链乘法
 */
public class MatrixChain_dp_v1 implements MatrixChain {

    public int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        int[][] g = new int[n][n]; //划分方法
        for (int len = 2; len < n; len++) {
            System.out.println("规模 " + len + " 时");
            for (int l = 1; l < n - len + 1; l++) { //子问题遍历
                int r = l + len - 1;
                System.out.println("子问题 dp[" + l + "]" + "[" + r + "]");
                dp[l][r] = Integer.MAX_VALUE; // 单个子问题的求解(动态性遍历)
                for (int k = l; k < r; k++) {
                    System.out.println("划分点" + "k=" + k + " dp[" + l + "]" + "[" + k + "]" + " + " + "dp[" + (k + 1) + "]" + "[" + r + "]" + " +" + " p" + "[" + (l - 1) + "]" + "*" + "p[" + k + "]" + "*" + "p[" + r + "]");
                    int cost = dp[l][k] + dp[k + 1][r] + (p[l - 1] * p[k] * p[r]);
                    if (cost < dp[l][r]) {
                        g[l][r] = k;
                        dp[l][r] = cost;
                    }
                }
            }
        }
        System.out.println("DP Table : ");
        for (int[] a : dp) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("分割方案 : ");
        for (int[] a : g) {
            System.out.println(Arrays.toString(a));
        }
        return dp[1][n - 1];
    }
}
