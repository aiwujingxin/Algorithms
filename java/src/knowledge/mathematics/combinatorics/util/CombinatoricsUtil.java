package knowledge.mathematics.combinatorics.util;

import knowledge.mathematics.MathUtil;

import java.math.BigInteger;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26 12:00
 * @description 组合计数基础模板
 * <模板选择>
 * - 精确计算单个 C(n,k): binomialExact，BigInteger，O(k)。
 * - 同一质数模数下多次查询 C/P: PrimeModCombinations，预处理 O(n)，单次 O(1)。
 * - 错排计数: derangements，递推 D(n)=(n-1)(D(n-1)+D(n-2))。
 * - 卡特兰数: catalanExact，C(2n,n)/(n+1)。
 * <易错提醒>
 * 1. 阶乘逆元公式要求 mod 为质数，且预处理上限 maxN < mod。
 * 2. 精确组合数很快超过 long，不能先用 long 乘完再转 BigInteger。
 * 3. “恰好/至少/至多”计数常需容斥；先定义全集和违规事件，再决定符号。
 */
public final class CombinatoricsUtil {

    private CombinatoricsUtil() {
    }

    /**
     * 精确计算 C(n,k)，利用对称性将复杂度降为 O(min(k,n-k))。
     */
    public static BigInteger binomialExact(int n, int k) {
        if (k < 0 || k > n) {
            return BigInteger.ZERO;
        }
        k = Math.min(k, n - k);
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i + 1))
                    .divide(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * 精确计算第 n 个卡特兰数。
     */
    public static BigInteger catalanExact(int n) {
        return binomialExact(2 * n, n).divide(BigInteger.valueOf(n + 1L));
    }

    /**
     * 返回 D(0)..D(n) 的错排数；long 能安全容纳到 D(20)。
     */
    public static long[] derangements(int n) {
        long[] derangement = new long[n + 1];
        derangement[0] = 1;
        if (n >= 1) {
            derangement[1] = 0;
        }
        for (int i = 2; i <= n; i++) {
            derangement[i] = Math.multiplyExact(i - 1L,
                    Math.addExact(derangement[i - 1], derangement[i - 2]));
        }
        return derangement;
    }

    /**
     * 质数模数组合数预处理模板。
     */
    public static final class PrimeModCombinations {
        private final long mod;
        private final long[] factorial;
        private final long[] inverseFactorial;

        public PrimeModCombinations(int maxN, long primeMod) {
            this.mod = primeMod;
            this.factorial = new long[maxN + 1];
            this.inverseFactorial = new long[maxN + 1];
            factorial[0] = 1;
            for (int i = 1; i <= maxN; i++) {
                factorial[i] = MathUtil.safeMul(factorial[i - 1], i, mod);
            }
            inverseFactorial[maxN] = MathUtil.modPow(factorial[maxN], mod - 2, mod);
            for (int i = maxN; i > 0; i--) {
                inverseFactorial[i - 1] = MathUtil.safeMul(inverseFactorial[i], i, mod);
            }
        }

        public long combination(int n, int k) {
            if (k < 0 || k > n) {
                return 0;
            }
            long denominatorInverse = MathUtil.safeMul(inverseFactorial[k],
                    inverseFactorial[n - k], mod);
            return MathUtil.safeMul(factorial[n], denominatorInverse, mod);
        }

        public long permutation(int n, int k) {
            if (k < 0 || k > n) {
                return 0;
            }
            return MathUtil.safeMul(factorial[n], inverseFactorial[n - k], mod);
        }
    }
}
