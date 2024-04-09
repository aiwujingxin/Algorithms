package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:49
 */
public class LeetCode7 {

    public int reverse(int x) {
        int rx = 0;
        int limit = Integer.MAX_VALUE / 10;
        boolean flag = x > 0;
        x = Math.abs(x);
        while (x > 0) {
            if (rx > limit) {
                return 0;
            }
            int t = x % 10;
            if (rx == limit) {
                if (flag && t > 7) {
                    return Integer.MAX_VALUE;
                }
                if (!flag && t > 8) {
                    return Integer.MIN_VALUE;
                }
            }
            rx = rx * 10 + t;
            x = x / 10;
        }
        return flag ? rx : -1 * rx;
    }
}
