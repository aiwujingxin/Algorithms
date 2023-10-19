package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 19:43
 */
public class LeetCode29 {
    //https://www.youtube.com/watch?v=XKuFGEGt5zo&t=199s
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
            // 不能 temp + temp >= dividend
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
