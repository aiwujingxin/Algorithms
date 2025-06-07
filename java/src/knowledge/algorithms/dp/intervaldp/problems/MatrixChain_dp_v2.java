package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 6/4/25 01:43
 */
public class MatrixChain_dp_v2 implements MatrixChain {

    public int matrixChainOrder(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];        // dp[i][j]: 矩阵 Ai...Aj 相乘的最小代价
        int[][] split = new int[n][n];     // split[i][j]: 最优划分点 k
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                System.out.println("计算子问题 dp[" + i + "][" + j + "]");
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (p[i - 1] * p[k] * p[j]);
                    System.out.println("尝试划分 k=" + k + "，计算代价：" + "dp[" + i + "][" + k + "](" + dp[i][k] + ") + " + "dp[" + (k + 1) + "][" + j + "](" + dp[k + 1][j] + ") + " + "p[" + (i - 1) + "] * p[" + k + "] * p[" + j + "] = " + p[i - 1] + " * " + p[k] + " * " + p[j] + " = " + cost);
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
                System.out.println();
            }
        }
        System.out.println("最终 DP 表:");
        for (int i = 1; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println("最终分割点表:");
        for (int i = 1; i < n; i++) {
            System.out.println(Arrays.toString(split[i]));
        }
        return dp[1][n - 1];
    }
}
