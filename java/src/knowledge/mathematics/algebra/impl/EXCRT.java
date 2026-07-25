package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description EXCRT
 */
public class EXCRT {
    /**
     * 扩展欧几里得算法
     * 返回数组 [d, x, y]，其中 d = gcd(a, b)，且满足 a*x + b*y = d
     */
    public static long[] exgcd(long a, long b) {
        if (b == 0) {
            return new long[]{a, 1, 0};
        }
        long[] res = exgcd(b, a % b);
        long d = res[0];
        long x = res[2];
        long y = res[1] - (a / b) * res[2];
        return new long[]{d, x, y};
    }

    /**
     * 快速乘 (防止两数相乘溢出 long)
     */
    public static long mul(long a, long b, long mod) {
        long res = 0;
        a = (a % mod + mod) % mod;
        b = (b % mod + mod) % mod;
        while (b > 0) {
            if ((b & 1) == 1) res = (res + a) % mod;
            a = (a + a) % mod;
            b >>= 1;
        }
        return res;
    }

    /**
     * 求解模线性方程组 (扩展中国剩余定理)
     * x ≡ a_i (mod m_i)
     *
     * @param a 余数数组
     * @param m 模数数组 (不要求互质)
     * @return 满足条件的最小非负解 x。如果无解返回 -1。
     */
    public static long excrt(long[] a, long[] m) {
        if (a.length == 0 || m.length == 0 || a.length != m.length) return -1;
        long M = m[0], ans = a[0];
        for (int i = 1; i < a.length; i++) {
            long c = (a[i] - ans % m[i] + m[i]) % m[i];
            long[] res = exgcd(M, m[i]);
            long d = res[0], x = res[1];
            if (c % d != 0) return -1; // 无解
            long bg = m[i] / d;
            x = mul(x, c / d, bg);
            ans += x * M;
            M *= bg;
            ans = (ans % M + M) % M;
        }
        return (ans % M + M) % M;
    }
}