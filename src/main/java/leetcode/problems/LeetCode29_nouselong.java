package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/12 01:21
 */
public class LeetCode29_nouselong {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1) {
            return -dividend;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sign = Integer.signum(dividend) * Integer.signum(divisor);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int res = 0;
        while (dividend <= divisor) {
            int help = divisor;
            while ((help >= Integer.MIN_VALUE >> 1) && dividend < (help << 1)) {
                help <<= 1;
            }
            res += help / divisor;
            dividend -= help;
        }
        return sign * res;
    }
}
