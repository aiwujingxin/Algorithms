package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:09
 */
public class StirlingNumbers {

    /**
     * 计算第二类斯特林数 S(n, k)
     * 将 n 个不同元素划分成 k 个非空子集的方案数
     *
     * @param n 元素数量
     * @param k 子集数量
     * @return S(n, k)
     */
    public long secondKind(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 && n == 0) {
            return 1;
        }
        if (k == 0 || n == 0) {
            return 0;
        }
        if (k == n || k == 1) {
            return 1;
        }
        // dp[i][j] 表示 S(i, j)
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i && j <= k; j++) {
                // S(i,j) = S(i-1, j-1) + j * S(i-1, j)
                dp[i][j] = dp[i - 1][j - 1] + j * dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    /**
     * 第二类斯特林数取模全表 S[i][j] (0<=i<=n, 0<=j<=k)，
     * 递推 S(i,j)=S(i-1,j-1)+j·S(i-1,j)，与 FirstKindStirling 的 API 对齐。
     */
    public static long[][] getSecondKind(int n, int k, long mod) {
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1 % mod;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + j * dp[i - 1][j]) % mod;
            }
        }
        return dp;
    }
}
