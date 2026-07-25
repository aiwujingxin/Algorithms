package knowledge.mathematics.algebra.impl;

import java.util.Random;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description MillerRabin
 */
public class MillerRabin {
    private static final Random RANDOM = new Random();

    /**
     * 快速乘
     */
    private static long mul(long a, long b, long mod) {
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
     * 快速幂
     */
    private static long pow(long base, long exp, long mod) {
        long res = 1;
        base = (base % mod + mod) % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = mul(res, base, mod);
            base = mul(base, base, mod);
            exp >>= 1;
        }
        return res;
    }

    /**
     * Miller-Rabin 素性测试
     *
     * @param n 待测试数字
     * @param k 测试次数，一般 8~10 次即可保证极高正确率
     * @return 是否为素数
     */
    public static boolean isPrime(long n, int k) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if ((n & 1) == 0) return false;

        long d = n - 1;
        int s = 0;
        while ((d & 1) == 0) {
            d >>= 1;
            s++;
        }

        for (int i = 0; i < k; i++) {
            long a = 2;
            if (n > 4) {
                long rnd = RANDOM.nextLong() & Long.MAX_VALUE;
                a = 2 + (rnd % (n - 3));
            }
            long x = pow(a, d, n);
            if (x == 1 || x == n - 1) continue;

            boolean composite = true;
            for (int j = 0; j < s - 1; j++) {
                x = mul(x, x, n);
                if (x == n - 1) {
                    composite = false;
                    break;
                }
            }
            if (composite) return false;
        }
        return true;
    }

    /**
     * 默认测试 10 次的 Miller-Rabin 测试
     */
    public static boolean isPrime(long n) {
        return isPrime(n, 10);
    }
}