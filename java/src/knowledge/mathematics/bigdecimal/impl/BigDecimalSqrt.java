package knowledge.mathematics.bigdecimal.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal 开平方模板 (ACM) - 基于牛顿迭代法
 *
 * @author wujingxinit@outlook.com
 * @date 2026/07/26
 * @description BigDecimalSqrt
 */
public class BigDecimalSqrt {

    /**
     * 计算大数的平方根
     *
     * @param value 待求平方根的数字
     * @param scale 结果保留的小数位数（精度）
     * @return 平方根
     */
    public static BigDecimal sqrt(BigDecimal value, int scale) {
        if (value.compareTo(BigDecimal.ZERO) < 0) {
            throw new ArithmeticException("Cannot calculate square root of a negative number");
        }
        if (value.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP);
        }

        // 初始猜测值可以使用 Math.sqrt 获取，以加快收敛速度
        // 这里为了防溢出，当数字非常大时，可以对半折算其有效位数，此处简化为转为 double 取近似值
        BigDecimal x0 = new BigDecimal(Math.sqrt(value.doubleValue()));
        if (x0.compareTo(BigDecimal.ZERO) == 0) {
            // 如果超出了 double 范围导致下溢出为 0，给一个初始值
            x0 = BigDecimal.ONE;
        }

        BigDecimal two = BigDecimal.valueOf(2);

        // 允许误差，根据精度 scale 设置 (例如 scale = 5 时，误差控制在 0.000001 级别)
        BigDecimal error = BigDecimal.ONE.movePointLeft(scale + 1);

        // 牛顿迭代公式: x_{n+1} = (x_n + a / x_n) / 2
        while (true) {
            // 计算过程中的精度一般多保留 2 位，避免中途丢失精度
            BigDecimal x1 = x0.add(value.divide(x0, scale + 2, RoundingMode.HALF_UP))
                    .divide(two, scale + 2, RoundingMode.HALF_UP);

            // 如果 |x1 - x0| < error，说明已经收敛到所需精度
            if (x1.subtract(x0).abs().compareTo(error) < 0) {
                return x1.setScale(scale, RoundingMode.HALF_UP);
            }
            x0 = x1;
        }
    }
}
