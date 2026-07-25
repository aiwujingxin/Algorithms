package knowledge.mathematics.combinatorics.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description StarsAndBars
 * 插板法 (Stars and Bars)
 * 用于求解将 n 个相同的物品分给 k 个不同的组的方案数。
 */
public class StarsAndBars {

    private long[] fact;
    private long[] invFact;
    private long mod;

    /**
     * 初始化阶乘和逆元
     *
     * @param maxVal 最大的物品数量或分组数
     * @param mod    取模数 (必须为素数)
     */
    public StarsAndBars(int maxVal, long mod) {
        this.mod = mod;
        fact = new long[maxVal + 1];
        invFact = new long[maxVal + 1];

        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= maxVal; i++) {
            fact[i] = fact[i - 1] * i % mod;
        }

        invFact[maxVal] = power(fact[maxVal], mod - 2, mod);
        for (int i = maxVal - 1; i >= 1; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % mod;
        }
    }

    // 快速幂
    private long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }

    // 计算组合数 C(n, r)
    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % mod * invFact[n - r] % mod;
    }

    /**
     * 方案一：每个组至少分到 1 个物品 (x_i >= 1)
     * 等价于方程 x_1 + x_2 + ... + x_k = n 的正整数解个数
     * 结果为 C(n - 1, k - 1)
     *
     * @param n 物品总数
     * @param k 组数
     * @return 方案数
     */
    public long distributeAtLeastOne(int n, int k) {
        if (n < k || k <= 0) return 0;
        return nCr(n - 1, k - 1);
    }

    /**
     * 方案二：每个组可以分到 0 个物品 (x_i >= 0)
     * 等价于方程 x_1 + x_2 + ... + x_k = n 的非负整数解个数
     * 结果为 C(n + k - 1, k - 1)
     *
     * @param n 物品总数
     * @param k 组数
     * @return 方案数
     */
    public long distributeAllowZero(int n, int k) {
        if (n < 0 || k <= 0) return 0;
        return nCr(n + k - 1, k - 1);
    }
}
