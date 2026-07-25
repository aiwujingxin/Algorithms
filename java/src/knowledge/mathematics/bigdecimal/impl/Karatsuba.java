package knowledge.mathematics.bigdecimal.impl;

import java.math.BigInteger;

/**
 * Karatsuba 大数乘法模板 (ACM)
 * 时间复杂度 O(N^(log_2(3))) ≈ O(N^1.585)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description Karatsuba
 */
public class Karatsuba {

    // 当位数小于等于阈值时，直接使用 BigInteger 原生的乘法，以提高效率
    private static final int THRESHOLD = 2000;

    /**
     * 使用 Karatsuba 算法计算两个大整数的乘积
     *
     * @param x 乘数 x
     * @param y 乘数 y
     * @return x * y
     */
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());

        // 如果数字位数较小，直接采用常规乘法更高效
        if (n <= THRESHOLD) {
            return x.multiply(y);
        }

        // 拆分位数，n 向上取半
        n = (n / 2) + (n % 2);

        // x = b * 2^n + a
        // y = d * 2^n + c
        BigInteger b = x.shiftRight(n);
        BigInteger a = x.subtract(b.shiftLeft(n));

        BigInteger d = y.shiftRight(n);
        BigInteger c = y.subtract(d.shiftLeft(n));

        // 递归计算三部分
        BigInteger ac = multiply(a, c);
        BigInteger bd = multiply(b, d);
        BigInteger abcd = multiply(a.add(b), c.add(d));

        // x * y = bd * 2^(2n) + ((a+b)(c+d) - ac - bd) * 2^n + ac
        BigInteger mid = abcd.subtract(ac).subtract(bd);

        return ac.add(mid.shiftLeft(n)).add(bd.shiftLeft(2 * n));
    }
}
