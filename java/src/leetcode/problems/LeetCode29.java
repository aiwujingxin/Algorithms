package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 10:16
 */
public class LeetCode29 {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        boolean flag = (dividend > 0) ^ (divisor > 0);
        int ldividend = dividend;
        int ldivisor = divisor;
        if (dividend > 0) {
            ldividend = -dividend;
        }
        if (divisor > 0) {
            ldivisor = -divisor;
        }
        int res = 0;
        while (ldividend <= ldivisor) {
            int temp = ldivisor;
            int cnt = 1;
            while (ldividend - temp <= temp) {
                cnt = cnt * 2;
                temp = temp * 2;
            }
            ldividend -= ldivisor * cnt;
            res += cnt;
        }
        return flag ? -res : res;
    }
}

