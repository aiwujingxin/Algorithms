package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:49
 */
public class LeetCode7 {

    public int reverse(int x) {
        int r = 0;
        while (x != 0) {
            int t = x % 10;
            if (r > Integer.MAX_VALUE / 10 || (r == Integer.MAX_VALUE / 10 && t > 7)) {
                return 0;
            }
            if (r < Integer.MIN_VALUE / 10 || (r == Integer.MIN_VALUE / 10 && t < -8)) {
                return 0;
            }
            r = r * 10 + t;
            x /= 10;
        }
        return r;
    }
}
