package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 23:36
 */
public class LeetCode29 {
    //https://www.youtube.com/watch?v=XKuFGEGt5zo&t=199s

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        //取反，防止溢出
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        int res = 0;
        while (dividend <= divisor) {
            int temp = divisor;
            int cnt = 1;
            while (temp >= dividend - temp) {
                temp = temp * 2;
                cnt = cnt * 2;
            }
            res += cnt;
            dividend -= temp;
        }
        return sign == -1 ? -res : res;
    }
}
