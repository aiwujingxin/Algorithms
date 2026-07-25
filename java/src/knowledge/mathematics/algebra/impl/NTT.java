package knowledge.mathematics.algebra.impl;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description 快速数论变换 (NTT) 多项式乘法
 * <适用场景>
 * 卷积计算：C[k]=Σ A[i]·B[k-i]。朴素卷积 O(n^2)，NTT 将其降到 O(n log n)。
 * 典型应用：大数乘法、生成函数、字符串匹配的位运算加速、计数 DP 的转移合并。
 * <核心原理>
 * 在模素数 p=998244353 下，g=3 是原根，存在 2^23 次单位根。
 * 把系数向量变换到“点值表示”后逐点相乘，再逆变换回系数——与 FFT 同构，但用整数免去浮点误差。
 */
public class NTT {

    private static final long MOD = 998244353L;
    private static final long PRIMITIVE_ROOT = 3L;

    private static long power(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    private static void transform(long[] a, boolean inverse) {
        int n = a.length;
        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            for (; (j & bit) != 0; bit >>= 1) j ^= bit;
            j ^= bit;
            if (i < j) {
                long tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        for (int len = 2; len <= n; len <<= 1) {
            long wn = power(PRIMITIVE_ROOT, (MOD - 1) / len, MOD);
            if (inverse) wn = power(wn, MOD - 2, MOD);
            for (int i = 0; i < n; i += len) {
                long w = 1;
                for (int k = 0; k < len / 2; k++) {
                    long u = a[i + k];
                    long v = a[i + k + len / 2] * w % MOD;
                    a[i + k] = (u + v) % MOD;
                    a[i + k + len / 2] = (u - v + MOD) % MOD;
                    w = w * wn % MOD;
                }
            }
        }
        if (inverse) {
            long invN = power(n, MOD - 2, MOD);
            for (int i = 0; i < n; i++) a[i] = a[i] * invN % MOD;
        }
    }

    /**
     * 多项式（或非负系数序列）卷积，结果对 998244353 取模。
     */
    public static long[] multiply(long[] a, long[] b) {
        int resultLen = a.length + b.length - 1;
        int n = 1;
        while (n < resultLen) n <<= 1;
        long[] fa = new long[n];
        long[] fb = new long[n];
        System.arraycopy(a, 0, fa, 0, a.length);
        System.arraycopy(b, 0, fb, 0, b.length);
        transform(fa, false);
        transform(fb, false);
        for (int i = 0; i < n; i++) fa[i] = fa[i] * fb[i] % MOD;
        transform(fa, true);
        long[] result = new long[resultLen];
        System.arraycopy(fa, 0, result, 0, resultLen);
        return result;
    }
}
