package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 二次剩余 (Legendre / Jacobi 符号 + Tonelli-Shanks 开方)
 * <适用场景>
 * 判断同余方程 x^2 ≡ n (mod p) 是否有解，并在有解时求出一个平方根。
 * 密码学、数论构造题以及某些计数题需要在模素数下开平方。
 * <核心>
 * - Legendre 符号 (n|p) = n^{(p-1)/2} mod p，取值 1（是二次剩余）/ -1 / 0。
 * - Tonelli-Shanks：把 p-1 写成 q·2^s，在 2-Sylow 子群里逐层校正，O(log^2 p)。
 */
public class QuadraticResidue {

    private static long power(long base, long exp, long mod) {
        long result = 1 % mod;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = mulMod(result, base, mod);
            base = mulMod(base, base, mod);
            exp >>= 1;
        }
        return result;
    }

    private static long mulMod(long a, long b, long mod) {
        return (a % mod) * (b % mod) % mod;
    }

    /**
     * 勒让德符号 (a|p)，p 为奇素数。返回 1 / -1 / 0。
     */
    public static int legendre(long a, long p) {
        long r = power(a, (p - 1) / 2, p);
        return r <= 1 ? (int) r : -1;
    }

    /**
     * 雅可比符号 (a|n)，n 为正奇数（推广的勒让德符号，n 可为合数）。
     */
    public static int jacobi(long a, long n) {
        a %= n;
        int result = 1;
        while (a != 0) {
            while ((a & 1) == 0) {
                a >>= 1;
                long mod8 = n & 7;
                if (mod8 == 3 || mod8 == 5) result = -result;
            }
            long tmp = a;
            a = n;
            n = tmp;
            if ((a & 3) == 3 && (n & 3) == 3) result = -result;
            a %= n;
        }
        return n == 1 ? result : 0;
    }

    /**
     * Tonelli-Shanks：求 x 使 x^2 ≡ n (mod p)，p 为奇素数。
     * 无解返回 -1；有解返回其中一个根（另一个根为 p - x）。
     */
    public static long sqrtMod(long n, long p) {
        n %= p;
        if (n == 0) return 0;
        if (legendre(n, p) != 1) return -1;
        if ((p & 3) == 3) return power(n, (p + 1) / 4, p);

        long q = p - 1;
        int s = 0;
        while ((q & 1) == 0) {
            q >>= 1;
            s++;
        }
        long z = 2;
        while (legendre(z, p) != -1) z++;

        long m = s;
        long c = power(z, q, p);
        long t = power(n, q, p);
        long r = power(n, (q + 1) / 2, p);
        while (t != 1) {
            long temp = t;
            int i = 0;
            while (temp != 1) {
                temp = mulMod(temp, temp, p);
                i++;
            }
            long b = power(c, 1L << (m - i - 1), p);
            m = i;
            c = mulMod(b, b, p);
            t = mulMod(t, c, p);
            r = mulMod(r, b, p);
        }
        return r;
    }
}
