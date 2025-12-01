package knowledge.mathematics.impl;

import java.util.*;


/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 05:09
 * @description MathUtil
 * @see leetcode.problems.LeetCode50
 * @see leetcode.problems.LeetCode372
 */
public class MathUtil {

    // ==================== 常量定义 ====================
    public static final long MOD = 1_000_000_007L;  // 默认模数 (需为质数)
    public static final int MAX_N = 100_000;        // 阶乘预处理上限

    private static final long[] fact = new long[MAX_N + 1];
    private static final long[] invFact = new long[MAX_N + 1];

    static {
        initFactorials();
    }

    // ==================== 预处理：阶乘 & 逆元 ====================
    private static void initFactorials() {
        fact[0] = 1;
        for (int i = 1; i <= MAX_N; i++) fact[i] = fact[i - 1] * i % MOD;
        invFact[MAX_N] = modPow(fact[MAX_N], MOD - 2, MOD);
        for (int i = MAX_N; i > 0; i--) invFact[i - 1] = invFact[i] * i % MOD;
    }

    // ==================== 1 数论 ==========================

    // ================== 1.1 安全模运算 ====================
    public static long safeAdd(long a, long b, long mod) {
        return (a + b) % mod;
    }

    public static long safeSub(long a, long b, long mod) {
        return (a - b + mod) % mod;
    }

    public static long safeMul(long a, long b, long mod) {
        return (a % mod) * (b % mod) % mod;
    }

    public static long safeMod(long x, long m) {
        return (x % m + m) % m;
    }

    // ================== 1.2. 快速幂 / 模逆元 ====================
    // 快速幂 (a^b % mod)
    public static long modPow(long a, long b, long mod) {
        long res = 1;
        a %= mod;
        while (b > 0) {
            if ((b & 1) != 0) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

    // 矩阵快速幂
    public static long[][] matPow(long[][] base, int b, long mod) {
        int n = base.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1; // 初始化为单位矩阵
        }
        long[][] temp = base;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = multiply(result, temp, mod);
            }
            temp = multiply(temp, temp, mod);
            b >>= 1;
        }
        return result;
    }

    public static long[][] multiply(long[][] A, long[][] B, long MOD) {
        int r = A.length, c = B[0].length, z = B.length;
        long[][] C = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    // 模逆元 (费马小定理，mod 为质数)
    public static long modInverse(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    // 模逆元 (扩展欧几里得)
    public static long modInverseGeneral(long a, long mod) {
        long[] r = extendedGcd(a, mod);
        if (r[0] != 1) throw new ArithmeticException("No modular inverse");
        return (r[1] % mod + mod) % mod;
    }

    // ==================== 1.3 GCD / LCM ====================
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // ==================== 1.4 扩展欧几里得算法 ====================

    /**
     * 扩展欧几里得算法: 返回 [g, x, y] 使 ax + by = g
     */
    public static long[] extendedGcd(long a, long b) {
        if (b == 0) return new long[]{a, 1, 0};
        long[] r = extendedGcd(b, a % b);
        return new long[]{r[0], r[2], r[1] - (a / b) * r[2]};
    }


    // ==================== 1.5 素数 ====================


    // ==================== 1.6 素数 ====================

    /**
     * 判断是否为质数 (√n 检查)
     */
    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (long i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }

    /**
     * 获取所有因子 O(√n)
     */
    public static Set<Integer> getFactors(int n) {
        Set<Integer> s = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                s.add(i);
                s.add(n / i);
            }
        }
        return s;
    }

    /**
     * 获取所有质因子 O(√n)
     */
    public static Set<Integer> getPrimeFactors(int n) {
        Set<Integer> s = new HashSet<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                s.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) s.add(n);
        return s;
    }

    /**
     * 线性筛求质数列表
     */
    public static List<Integer> primeSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (long j = (long) i * i; j <= n; j += i)
                    isPrime[(int) j] = false;
            }
        }
        return primes;
    }


    // ==================== 3 组合 & 排列 ====================

    /**
     * C(n, k) = n! / (k! * (n - k)!) % MOD
     */
    public static long C(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }

    /**
     * P(n, k) = n! / (n - k)! % MOD
     */
    public static long P(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[n - k] % MOD;
    }

    // 斐波那契数列第 n 项
    public static long fibonacci(int n, long mod) {
        if (n <= 1) return n;
        long[][] T = {{1, 1}, {1, 0}};
        return matPow(T, n - 1, mod)[0][0];
    }

    // ==================== 数学扩展 ====================

    /**
     * 整除判断
     */
    public static boolean divides(long a, long b) {
        return b % a == 0;
    }

    /**
     * 判断是否为幂
     */
    public static boolean isPowerOf(long n, long base) {
        if (n < 1 || base < 2) return false;
        while (n % base == 0) n /= base;
        return n == 1;
    }

    /**
     * 模意义下的加法链 (a + b + c + ... % mod)
     */
    public static long modSum(long[] arr, long mod) {
        long sum = 0;
        for (long x : arr) sum = (sum + x) % mod;
        return sum;
    }

    // ==================== 取整函数 ====================
    public static long ceilDiv(long a, long b) {
        return (a + b - 1) / b;
    }

    public static int upToMultiple(int x, int k) {
        return (int) ceilDiv(x, k) * k;
    }

    public static int downToMultiple(int x, int k) {
        return (x / k) * k;
    }

}
