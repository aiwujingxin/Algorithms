package leetcode.lists.LCR;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 00:27
 */
public class LCR1 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int res = 0;
        while (dividend <= divisor) {
            int count = 1;
            int temp = divisor;
            // temp + temp >= dividend
            while (temp >= dividend - temp) {
                temp += temp;
                count += count;
            }
            res += count;
            dividend -= temp;
        }
        return sign == -1 ? -res : res;
    }
}
