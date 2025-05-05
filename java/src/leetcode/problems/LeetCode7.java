package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:49
 */
public class LeetCode7 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int t = x % 10;
            x /= 10;
            // 溢出检查
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && t > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && t < -8)) {
                return 0;
            }
            res = res * 10 + t;
        }
        return res;
    }
}
