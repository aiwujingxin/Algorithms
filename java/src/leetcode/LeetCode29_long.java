package leetcode;

/**
 * @author jingxinwu
 * @date 2021-06-16 11:28 下午
 */
public class LeetCode29_long {

    //https://www.youtube.com/watch?v=XKuFGEGt5zo&t=199s
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long ldividend = Math.abs((long) (dividend));
        long ldivisor = Math.abs((long) (divisor));
        long res = 0;
        while (ldivisor <= ldividend) {
            long temp = ldivisor;
            long mul = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            ldividend = ldividend - temp;
            res += mul;

        }
        res = res * sign;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;
    }
}
