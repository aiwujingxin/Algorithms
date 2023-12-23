package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/23 19:26
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
        int ldividend = -Math.abs(dividend);
        int ldivisor = -Math.abs(divisor);
        int res = 0;
        while (ldividend < ldivisor) {
            int temp = ldivisor;
            int t = 1;
            while (ldividend - temp < temp) {
                temp = temp * 2;
                t = t * 2;
            }
            ldividend -= ldivisor * t;
            res += t;
        }
        return sign * res;
    }
}
