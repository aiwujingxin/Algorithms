package basic.algorithm.dp.knapsack.lintCode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/7 22:17
 * <a href="https://www.lintcode.com/problem/92/">Backpack</a>
 */
/*
 * 在 n 个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 *（每个物品只能选择一次且物品大小均为正整数）
 */
public class Backpack {

    public int backPack_2d(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + A[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }

    public int backPack_1d(int m, int[] A) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
                }
            }
        }
        return dp[m];
    }
}
