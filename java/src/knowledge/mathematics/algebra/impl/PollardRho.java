package knowledge.mathematics.algebra.impl;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description Pollard-Rho 大数分解
 * <适用场景>
 * MillerRabin 只回答“是不是质数”，PollardRho 回答“合数由哪些质因子组成”。
 * 二者配套：先用 MillerRabin 判素作为递归终点，再用 Pollard-Rho 拆出一个非平凡因子。
 * <核心原理>
 * 构造伪随机序列 x_{i+1}=x_i^2+c，由生日悖论期望 O(n^{1/4}) 步出现循环；
 * 循环出现时 gcd(|x_i - x_j|, n) 大概率给出 n 的一个非平凡因子。
 * 倍增步长 + 批量乘法累积 gcd，显著降低取 gcd 的常数。
 */
public class PollardRho {

    private static final Random RANDOM = new Random();

    // a + b (mod mod)，利用有符号溢出规则支持 mod 接近 2^63
    private static long addMod(long a, long b, long mod) {
        long s = a + b;
        if (s < 0 || s >= mod) s -= mod;
        return s;
    }

    // a * b (mod mod)，通过 128 位乘积的高低位归约，全程无溢出
    private static long mulMod(long a, long b, long mod) {
        long low = a * b;
        long high = Math.multiplyHigh(a, b);
        long remainder = Long.remainderUnsigned(low, mod);
        long carry = Long.remainderUnsigned(-mod, mod); // 2^64 mod mod
        long extra = 0;
        while (high != 0) {
            if ((high & 1) == 1) extra = addMod(extra, carry, mod);
            carry = addMod(carry, carry, mod);
            high >>>= 1;
        }
        return addMod(remainder, extra, mod);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static long next(long x, long c, long mod) {
        return addMod(mulMod(x, x, mod), c, mod);
    }

    /**
     * 返回合数 n 的一个非平凡因子。倍增步长 + 批量乘法累积 gcd，失败则换随机参数重试。
     */
    public static long findFactor(long n) {
        if ((n & 1) == 0) return 2;
        while (true) {
            long c = 1 + (RANDOM.nextLong() & Long.MAX_VALUE) % (n - 1);
            long x = (RANDOM.nextLong() & Long.MAX_VALUE) % n;
            long y = x;
            long product = 1;
            long divisor = 1;
            boolean cycled = false;
            for (int step = 1; divisor == 1 && !cycled; step <<= 1) {
                long snapshotY = y;
                long snapshotProduct = product;
                for (int i = 0; i < step; i++) {
                    y = next(y, c, n);
                    long diff = x >= y ? x - y : y - x;
                    if (diff == 0) {
                        cycled = true;
                        break;
                    }
                    product = mulMod(product, diff, n);
                }
                if (cycled) break;
                divisor = gcd(product, n);
                if (divisor == n) {
                    y = snapshotY;
                    product = snapshotProduct;
                    divisor = 1;
                    for (int i = 0; i < step; i++) {
                        y = next(y, c, n);
                        long diff = x >= y ? x - y : y - x;
                        divisor = gcd(diff, n);
                        if (divisor > 1) break;
                    }
                }
                x = y;
            }
            if (divisor > 1 && divisor < n) return divisor;
        }
    }

    /**
     * 完整质因数分解，返回 {质因子 -> 指数}，按质因子递增迭代。
     */
    public static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> factors = new TreeMap<>();
        decompose(n, factors);
        return factors;
    }

    private static void decompose(long n, Map<Long, Integer> factors) {
        if (n == 1) return;
        if (MillerRabin.isPrime(n)) {
            factors.merge(n, 1, Integer::sum);
            return;
        }
        long factor = findFactor(n);
        decompose(factor, factors);
        decompose(n / factor, factors);
    }
}
