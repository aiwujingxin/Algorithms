package knowledge.mathematics.algebra.util;

import knowledge.mathematics.MathUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2026/07/26 12:00
 * @description 基础数论模板
 * <模板选择>
 * - 单个整数分解质因数: factorize，O(sqrt(n))。
 * - 单个整数欧拉函数: eulerPhi，O(sqrt(n))。
 * - 一次同余方程 ax ≡ b (mod m): solveLinearCongruence。
 * - 两两互质模数的同余方程组: chineseRemainder。
 * - [1, n] 全部欧拉函数: phiTable，O(n log log n)。
 * <易错提醒>
 * 1. 乘法和合并模数可能溢出 long，模板使用 Math.multiplyExact 主动暴露风险。
 * 2. ax ≡ b (mod m) 有解当且仅当 gcd(a,m) | b；有解时模 m/gcd(a,m) 唯一。
 * 3. 当前 CRT 模板要求模数两两互质；一般 CRT 需要额外处理不相容方程。
 */
public final class NumberTheory {

    private NumberTheory() {
    }

    /**
     * 返回质因数及其指数，迭代顺序按质因数递增。
     */
    public static Map<Long, Integer> factorize(long n) {
        Map<Long, Integer> factors = new LinkedHashMap<>();
        for (long factor = 2; factor <= n / factor; factor += factor == 2 ? 1 : 2) {
            int exponent = 0;
            while (n % factor == 0) {
                n /= factor;
                exponent++;
            }
            if (exponent > 0) {
                factors.put(factor, exponent);
            }
        }
        if (n > 1) {
            factors.put(n, 1);
        }
        return factors;
    }

    /**
     * 枚举正整数 n 的全部正因子，结果递增。
     */
    public static List<Long> divisors(long n) {
        List<Long> small = new ArrayList<>();
        List<Long> large = new ArrayList<>();
        for (long factor = 1; factor <= n / factor; factor++) {
            if (n % factor == 0) {
                small.add(factor);
                if (factor != n / factor) {
                    large.add(n / factor);
                }
            }
        }
        for (int i = large.size() - 1; i >= 0; i--) {
            small.add(large.get(i));
        }
        return small;
    }

    /**
     * 欧拉函数 φ(n)：[1,n] 中与 n 互质的整数个数。
     */
    public static long eulerPhi(long n) {
        long result = n;
        for (long prime : factorize(n).keySet()) {
            result = result / prime * (prime - 1);
        }
        return result;
    }

    /**
     * 筛出 φ(0)..φ(n)，适合多次查询。
     */
    public static int[] phiTable(int n) {
        int[] phi = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            phi[i] = i;
        }
        for (int prime = 2; prime <= n; prime++) {
            if (phi[prime] == prime) {
                for (int multiple = prime; multiple <= n; multiple += prime) {
                    phi[multiple] = phi[multiple] / prime * (prime - 1);
                }
            }
        }
        return phi;
    }

    /**
     * 求 ax ≡ b (mod mod) 的最小非负解。
     *
     * @return {x, solutionMod}，所有解为 x + k * solutionMod；无解返回空数组
     */
    public static long[] solveLinearCongruence(long a, long b, long mod) {
        long gcd = MathUtil.gcd(a, mod);
        if (b % gcd != 0) {
            return new long[0];
        }
        long reducedA = a / gcd;
        long reducedB = b / gcd;
        long solutionMod = mod / gcd;
        long inverse = MathUtil.modInverseGeneral(reducedA, solutionMod);
        long x = MathUtil.safeMul(inverse, reducedB, solutionMod);
        return new long[]{x, solutionMod};
    }

    /**
     * 中国剩余定理：模数必须为正数且两两互质。
     *
     * @return {最小非负解, 所有模数之积}
     */
    public static long[] chineseRemainder(long[] remainders, long[] moduli) {
        long product = 1;
        for (int i = 0; i < moduli.length; i++) {
            product = Math.multiplyExact(product, moduli[i]);
        }
        long answer = 0;
        for (int i = 0; i < moduli.length; i++) {
            long partial = product / moduli[i];
            long inverse = MathUtil.modInverseGeneral(partial, moduli[i]);
            long term = MathUtil.safeMul(remainders[i], partial, product);
            term = MathUtil.safeMul(term, inverse, product);
            answer = MathUtil.safeAdd(answer, term, product);
        }
        return new long[]{answer, product};
    }
}
