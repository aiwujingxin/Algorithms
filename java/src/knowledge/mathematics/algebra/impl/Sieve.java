package knowledge.mathematics.algebra.impl;

import knowledge.mathematics.algebra.problems.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 12/21/25 02:24
 * @description 筛法求质数
 * @see HDU1262   寻找素数对 A+B=M
 * @see HDU2710   求哪个数的最大质因子最大
 * @see HDU3792   孪生素数个数
 * @see HDU3826   分解质因子
 * @see HDU6069   区间素数
 */
public class Sieve {

    /**
     * 埃氏筛 (Eratosthenes Sieve) - 优化版
     * 时间复杂度: O(N log log N)
     */
    public static class EratosthenesSieve {
        public static boolean[] notPrime;

        public static void initPrimes(int n) {
            checkUpperBound(n);
            notPrime = new boolean[n + 1];
            notPrime[0] = true;
            if (n >= 1) {
                notPrime[1] = true;
            }
            for (int i = 2; i <= n / i; i++) {
                if (!notPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        notPrime[j] = true;
                    }
                }
            }
        }
    }

    /**
     * 线性筛 (Euler Sieve) - 真正的线性复杂度
     * 时间复杂度: O(N)
     */
    public static class EulerSieve {
        public static boolean[] notPrime;
        public static int[] primes;
        public static int primeCount;

        public static void initPrimes(int n) {
            checkUpperBound(n);
            primeCount = 0;
            notPrime = new boolean[n + 1];
            primes = new int[n + 1];
            notPrime[0] = true;
            if (n >= 1) {
                notPrime[1] = true;
            }
            for (int i = 2; i <= n; i++) {
                if (!notPrime[i]) {
                    primes[primeCount++] = i;
                }
                for (int j = 0; j < primeCount && (long) i * primes[j] <= n; j++) {
                    notPrime[i * primes[j]] = true;
                    if (i % primes[j] == 0) break;
                }
            }
        }

        /**
         * 欧拉筛 (线性筛) - 获取 n 以内的所有质数
         * 时间复杂度: O(N)
         */
        public static List<Integer> getPrimes(int n) {
            checkUpperBound(n);
            boolean[] notPrime = new boolean[n + 1];
            notPrime[0] = true;
            if (n >= 1) {
                notPrime[1] = true;
            }
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (!notPrime[i]) {
                    primes.add(i);
                }
                for (int p : primes) {
                    if ((long) i * p > n) break;
                    notPrime[i * p] = true;
                    if (i % p == 0) break;
                }
            }
            return primes;
        }
    }

    /**
     * 最小质因子筛 (Smallest Prime Factor)
     * spf[x] 记录 x 的最小质因子，预处理后可 O(log x) 完成质因数分解。
     * 时间复杂度: O(N)
     */
    public static class SmallestPrimeFactor {
        public static int[] spf;

        public static void init(int n) {
            checkUpperBound(n);
            spf = new int[n + 1];
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (spf[i] == 0) {
                    spf[i] = i;
                    primes.add(i);
                }
                for (int p : primes) {
                    if ((long) i * p > n) break;
                    spf[i * p] = p;
                    if (i % p == 0) break;
                }
            }
        }

        /**
         * 借助 spf 表在 O(log x) 内分解质因数，返回 {质因子 -> 指数}。
         */
        public static Map<Integer, Integer> factorize(int x) {
            Map<Integer, Integer> factors = new LinkedHashMap<>();
            while (x > 1) {
                int p = spf[x];
                while (x % p == 0) {
                    x /= p;
                    factors.merge(p, 1, Integer::sum);
                }
            }
            return factors;
        }
    }

    /**
     * 区间筛求质数 isPrime[i] 表示 L+i 是否为质数
     */
    public static class SegmentedSieve {

        public static boolean[] segmentSieve(long L, long R) {
            if (L < 0 || L > R) {
                throw new IllegalArgumentException("区间必须满足 0 <= L <= R");
            }
            long root = (long) Math.sqrt(R);
            while (root < Long.MAX_VALUE && root + 1 <= R / (root + 1)) root++;
            while (root > 0 && root > R / root) root--;
            if (root > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("sqrt(R) 超出数组可索引范围");
            }
            int n = (int) root;
            // 1) 普通筛：得到 <= sqrt(R) 的所有质数
            boolean[] notPrime = new boolean[n + 1];
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (!notPrime[i]) {
                    primes.add(i);
                    if ((long) i * i <= n) {
                        for (int j = i * i; j <= n; j += i) notPrime[j] = true;
                    }
                }
            }
            // 2) 分段筛：[L, R]
            int len = Math.toIntExact(Math.addExact(Math.subtractExact(R, L), 1));
            boolean[] isPrime = new boolean[len];
            Arrays.fill(isPrime, true);
            // 处理 0/1
            if (L == 0) {
                if (len > 0) isPrime[0] = false;
                if (len > 1) isPrime[1] = false;
            } else if (L == 1) {
                isPrime[0] = false;
            }
            for (int p : primes) {
                // p*p：从 p 的平方开始筛是经典优化
                // 1) 小于 p*p 的 p 的倍数（如 2p,3p,...）已经会被更小的质数筛掉
                // 2) 也避免当区间包含 p 本身时（L <= p <= R）把 p 误标为合数
                long pp = (long) p * p;
                // 计算区间 [L, R] 内第一个 >= L 的 p 的倍数：
                // ceil(L / p) * p  —— 这里用 (L + p - 1) / p 实现上取整（仅适用于 L >= 0 的情况）
                long firstMultiple = ((L + p - 1) / p) * (long) p;
                // 起点取 max(p*p, firstMultiple)：
                // - 保证从区间内的第一个倍数开始（不漏标）
                // - 同时不从 p 本身开始（不误标），并减少重复标记
                long start = Math.max(pp, firstMultiple);
                // 从 start 开始每次加 p，标记区间内所有 p 的倍数为“非质数”
                // isPrime[idx] 对应的实际数字是 (L + idx)，所以 x 的下标是 (x - L)
                for (long x = start; x <= R; x += p) {
                    isPrime[(int) (x - L)] = false;
                }
            }
            return isPrime;
        }
    }

    private static void checkUpperBound(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("上界不能为负数");
        }
    }
}
