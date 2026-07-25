package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 多项式系数 (Multinomial Coefficient)
 * <本质>
 * 把 n 个物品分成若干组、每组大小为 counts[i] 的方案数：
 * n! / (counts[0]! · counts[1]! · ... )，其中 Σ counts[i] = n。
 * 等价于把多重集全排列去重，是可重排列计数与生成函数展开的核心。
 * <实现>
 * 预处理阶乘与阶乘逆元后，一次连乘即可 O(组数) 得到结果，mod 需为质数。
 */
public class Multinomial {

    private final long mod;
    private final long[] factorial;
    private final long[] inverseFactorial;

    public Multinomial(int maxN, long primeMod) {
        this.mod = primeMod;
        this.factorial = new long[maxN + 1];
        this.inverseFactorial = new long[maxN + 1];
        factorial[0] = 1 % mod;
        for (int i = 1; i <= maxN; i++) factorial[i] = factorial[i - 1] * i % mod;
        inverseFactorial[maxN] = power(factorial[maxN], mod - 2);
        for (int i = maxN; i > 0; i--) inverseFactorial[i - 1] = inverseFactorial[i] * i % mod;
    }

    /**
     * 多项式系数 (Σcounts)! / Πcounts[i]!，对质数 mod 取模。
     */
    public long multinomial(int[] counts) {
        int total = 0;
        for (int c : counts) total += c;
        long result = factorial[total];
        for (int c : counts) result = result * inverseFactorial[c] % mod;
        return result;
    }

    private long power(long base, long exp) {
        long res = 1 % mod;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }
}
