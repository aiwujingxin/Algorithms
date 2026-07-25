package knowledge.mathematics.combinatorics.impl;

/**
 * 整数划分 (Integer Partition)
 * 计算将正整数 n 拆分成若干个正整数之和的方案数。
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description IntegerPartition
 */
public class IntegerPartition {

    /**
     * 动态规划求整数划分：将 n 划分为不超过 k 个正整数之和
     * 递推式: dp[i][j] = dp[i-1][j-1] + dp[i-j][j]
     * 时间复杂度: O(n * k)
     *
     * @param n   待划分的整数
     * @param k   最大划分部分数
     * @param mod 取模数
     * @return 方案数
     */
    public static long partitionDP(int n, int k, long mod) {
        if (n < 0 || k < 0) return 0;
        long[][] dp = new long[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - j][j]) % mod;
            }
        }
        return dp[n][k];
    }

    /**
     * 完全背包求整数划分：将 n 划分为任意多个正整数之和
     * 时间复杂度: O(n^2)
     *
     * @param n   待划分的整数
     * @param mod 取模数
     * @return 方案数
     */
    public static long partitionKnapsack(int n, long mod) {
        if (n < 0) return 0;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - i]) % mod;
            }
        }
        return dp[n];
    }

    /**
     * 五边形数定理 (Pentagonal Number Theorem) 求整数划分
     * 求解将 n 划分为任意多个正整数之和的所有 P(1...n)
     * 时间复杂度: O(n * sqrt(n))
     *
     * @param n   待划分的最大整数
     * @param mod 取模数
     * @return P(0...n) 的划分数数组
     */
    public static long[] partitionPentagonal(int n, long mod) {
        if (n < 0) return new long[0];
        long[] p = new long[n + 1];
        p[0] = 1;

        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int k = 1; ; k++) {
                // 广义五边形数
                int g1 = k * (3 * k - 1) / 2;
                int g2 = k * (3 * k + 1) / 2;

                if (g1 > i) break;

                long term = p[i - g1];
                if (g2 <= i) {
                    term = (term + p[i - g2]) % mod;
                }

                if (k % 2 == 1) {
                    sum = (sum + term) % mod;
                } else {
                    sum = (sum - term + mod) % mod;
                }
            }
            p[i] = sum;
        }
        return p;
    }
}
