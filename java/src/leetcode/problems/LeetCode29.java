package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 17:41
 */
public class LeetCode29 {

    public int divide(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (a > 0) ^ (b > 0);
        int res = 0;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        while (a <= b) {
            int t = b;
            int cnt = 1;
            while (a - t <= t) {
                t <<= 1;
                cnt <<= 1;
            }
            a -= cnt * b;
            res += cnt;
        }
        return sign ? -res : res;
    }
}
