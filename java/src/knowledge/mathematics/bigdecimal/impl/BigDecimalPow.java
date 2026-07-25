package knowledge.mathematics.bigdecimal.impl;

import java.math.BigDecimal;

/**
 * BigDecimal 快速幂模板 (ACM)
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description BigDecimalPow
 */
public class BigDecimalPow {

    /**
     * 计算大数的整数次幂 (快速幂算法，O(log N) 时间复杂度)
     *
     * @param base 底数
     * @param exp  指数 (必须大于等于0)
     * @return base 的 exp 次幂
     */
    public static BigDecimal pow(BigDecimal base, long exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative in this template");
        }

        BigDecimal res = BigDecimal.ONE;
        BigDecimal a = base;

        while (exp > 0) {
            // 如果最低位是 1，累乘到结果中
            if ((exp & 1) == 1) {
                res = res.multiply(a);
            }
            // 底数平方
            a = a.multiply(a);
            // 指数右移一位
            exp >>= 1;
        }

        return res;
    }
}
