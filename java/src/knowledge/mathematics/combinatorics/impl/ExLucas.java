package knowledge.mathematics.combinatorics.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 扩展卢卡斯定理 (exLucas)
 * <适用场景>
 * 求 C(n, m) mod p，其中 p 为任意正整数（不必是素数）——普通 Lucas 只处理素数模。
 * <核心思想>
 * 把 p 质因数分解为 Π p_i^{a_i}，分别在每个素数幂模下用 Wilson/阶乘剥离法算出 C(n,m) mod p_i^{a_i}，
 * 再用中国剩余定理合并。计算 n! 中 p 的幂次时递归剔除 p 的倍数即可。
 */
public class ExLucas {

    private static long[] exgcd(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = exgcd(b, a % b);
        return new long[]{r[0], r[2], r[1] - (a / b) * r[2]};
    }

    private static long inverse(long a, long mod) {
        long[] g = exgcd((a % mod + mod) % mod, mod);
        return (g[1] % mod + mod) % mod;
    }

    private static long power(long base, long exp, long mod) {
        long res = 1 % mod;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }

    // 计算 n! 中去掉所有 prime 因子后的“阶乘部分”对 primePower 取模
    private static long factorialWithoutPrime(long n, long prime, long primePower) {
        if (n == 0) return 1;
        long result = 1;
        // 完整周期部分：[1, primePower] 内不含 prime 的乘积，其幂次为 n / primePower
        for (long i = 2; i <= primePower; i++) {
            if (i % prime != 0) result = result * i % primePower;
        }
        result = power(result, n / primePower, primePower);
        // 残余部分：[primePower*k+1, n] 的尾巴
        for (long i = 2; i <= n % primePower; i++) {
            if (i % prime != 0) result = result * i % primePower;
        }
        // 递归处理 prime 的倍数：n! = (n/prime)! · prime^{n/prime} · (不含prime部分)
        return result * factorialWithoutPrime(n / prime, prime, primePower) % primePower;
    }

    // prime 在 n! 中的幂次
    private static long primeExponent(long n, long prime) {
        long count = 0;
        while (n > 0) {
            n /= prime;
            count += n;
        }
        return count;
    }

    // C(n,m) mod prime^k
    private static long binomialPrimePower(long n, long m, long prime, long primePower) {
        long exponent = primeExponent(n, prime) - primeExponent(m, prime) - primeExponent(n - m, prime);
        if (exponent >= 63) return 0;
        long numerator = factorialWithoutPrime(n, prime, primePower);
        long denominator = factorialWithoutPrime(m, prime, primePower)
                * factorialWithoutPrime(n - m, prime, primePower) % primePower;
        long result = numerator * inverse(denominator, primePower) % primePower;
        return result * power(prime, exponent, primePower) % primePower;
    }

    /**
     * 求 C(n, m) mod p，p 为任意正整数。
     */
    public static long exLucas(long n, long m, long p) {
        if (m < 0 || m > n) return 0;
        List<Long> moduli = new ArrayList<>();
        List<Long> remainders = new ArrayList<>();
        long temp = p;
        for (long prime = 2; prime * prime <= temp; prime++) {
            if (temp % prime == 0) {
                long primePower = 1;
                while (temp % prime == 0) {
                    temp /= prime;
                    primePower *= prime;
                }
                moduli.add(primePower);
                remainders.add(binomialPrimePower(n, m, prime, primePower));
            }
        }
        if (temp > 1) {
            moduli.add(temp);
            remainders.add(binomialPrimePower(n, m, temp, temp));
        }
        // CRT 合并
        long mod = 1, answer = 0;
        for (long factor : moduli) mod *= factor;
        for (int i = 0; i < moduli.size(); i++) {
            long partial = mod / moduli.get(i);
            long inv = inverse(partial % moduli.get(i), moduli.get(i));
            answer = (answer + remainders.get(i) * partial % mod * inv) % mod;
        }
        return (answer % mod + mod) % mod;
    }
}
