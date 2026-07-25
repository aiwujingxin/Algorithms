package knowledge.mathematics.combinatorics.impl;

/**
 * 第一类斯特林数 (Stirling Numbers of the First Kind)
 * s(n, k) 表示将 n 个不同元素排成 k 个非空循环排列的方法数。
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description FirstKindStirling
 */
public class FirstKindStirling {

    /**
     * 计算无符号第一类斯特林数 (O(n * k) 动态规划)
     * 递推公式: s(n, k) = s(n-1, k-1) + (n-1) * s(n-1, k)
     *
     * @param n   元素总数
     * @param k   循环排列数
     * @param mod 取模数
     * @return 包含无符号第一类斯特林数的二维数组
     */
    public static long[][] getUnsignedStirling1(int n, int k, long mod) {
        long[][] s = new long[n + 1][k + 1];
        s[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                s[i][j] = (s[i - 1][j - 1] + (i - 1) * s[i - 1][j] % mod) % mod;
            }
        }
        return s;
    }

    /**
     * 计算有符号第一类斯特林数
     * 递推公式: s(n, k) = s(n-1, k-1) - (n-1) * s(n-1, k)
     *
     * @param n   元素总数
     * @param k   循环排列数
     * @param mod 取模数
     * @return 包含有符号第一类斯特林数（已转换为正数取模结果）的二维数组
     */
    public static long[][] getSignedStirling1(int n, int k, long mod) {
        long[][] s = new long[n + 1][k + 1];
        s[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                s[i][j] = (s[i - 1][j - 1] - (i - 1) * s[i - 1][j] % mod + mod) % mod;
            }
        }
        return s;
    }
}
