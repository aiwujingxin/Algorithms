package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/21 21:26
 */
public class LeetCode29_use_long {

    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        long res = 0;
        while (ldivisor <= ldividend) {
            long temp = ldivisor;
            long mul = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            res += mul;
            ldividend -= temp;
        }
        res *= sign;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}


