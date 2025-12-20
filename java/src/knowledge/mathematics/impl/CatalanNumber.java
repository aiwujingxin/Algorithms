package knowledge.mathematics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:08
 * @description 卡特兰数
 */
public class CatalanNumber {

    /**
     * 方法一：使用组合公式 C(n) = C(2n, n)/ (n+1)
     * 需要用到上面实现的二项式系数函数。
     * 这是计算单个卡特兰数最高效的方法。
     *
     * @param n 索引 (n >= 0)
     * @return 第 n 个卡特兰数
     */
    public long getCatalanByCombination(int n) {
        if (n < 0) return 0;
        PascalsTriangle pt = new PascalsTriangle();
        long c2n_n = pt.binomialCoefficient(2 * n, n);
        return c2n_n / (n + 1);
    }

    /**
     * 方法二：动态规划 (使用递推公式)
     * 适用于需要计算一系列卡特兰数的情况。
     *
     * @param n 最大索引
     * @return 包含 C(0) 到 C(n) 的数组
     */
    public long[] generateCatalanSeries(int n) {
        if (n < 0) return new long[0];
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - 1 - j];
            }
        }
        return catalan;
    }
}
