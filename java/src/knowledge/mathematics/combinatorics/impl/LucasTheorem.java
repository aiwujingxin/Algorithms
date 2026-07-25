package knowledge.mathematics.combinatorics.impl;

/**
 * Lucas定理 (Lucas Theorem)
 * 用于求解大组合数取模的问题：C(n, m) % p，其中 p 必须为素数。
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description LucasTheorem
 */
public class LucasTheorem {

    // 快速幂 base^exp % mod
    public static long power(long base, long exp, long mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

    // 求逆元 (基于费马小定理，p必须为素数)
    public static long modInverse(long n, long p) {
        return power(n, p - 2, p);
    }

    // 计算 C(n, m) % p，其中 n, m < p
    public static long nCrModP(long n, long m, long p) {
        if (m > n) return 0;
        if (m == 0 || m == n) return 1;
        if (m > n - m) m = n - m;

        long num = 1, den = 1;
        for (long i = 0; i < m; i++) {
            num = (num * (n - i)) % p;
            den = (den * (i + 1)) % p;
        }
        return (num * modInverse(den, p)) % p;
    }

    /**
     * Lucas定理求 C(n, m) % p
     *
     * @param n 底数
     * @param m 顶数
     * @param p 质数模数
     * @return C(n, m) % p
     */
    public static long lucas(long n, long m, long p) {
        if (m == 0) return 1;
        return (nCrModP(n % p, m % p, p) * lucas(n / p, m / p, p)) % p;
    }
}
