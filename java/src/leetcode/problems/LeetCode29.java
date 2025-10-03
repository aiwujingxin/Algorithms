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
        boolean s = (a > 0) ^ (b > 0);
        int r = 0;
        if (a > 0) a = -a;
        if (b > 0) b = -b;
        while (a <= b) {
            int t = b;
            int c = 1;
            while (a - t <= t) {
                t <<= 1;
                c <<= 1;
            }
            a -= c * b;
            r += c;
        }
        return s ? -r : r;
    }
}
