package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:41
 */
public class LeetCode29 {

    public int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int res = 0;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int t = divisor;
            int cnt = 1;
            while (dividend - t <= t) {
                t = t * 2;
                cnt = cnt * 2;
            }
            dividend -= cnt * divisor;
            res += cnt;
        }
        return sign ? -res : res;
    }
}
