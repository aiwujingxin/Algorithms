package knowledge.mathematics.impl;

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
}
