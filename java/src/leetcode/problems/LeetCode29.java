package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/11 14:42
 */
public class LeetCode29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
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
            int tmp = divisor;
            int cnt = 1;
            while (dividend - tmp <= tmp) {
                cnt = cnt * 2;
                tmp = tmp * 2;
            }
            res += cnt;
            dividend -= tmp;
        }
        return sign == -1 ? -res : res;
    }
}
