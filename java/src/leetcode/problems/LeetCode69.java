package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 11:23
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        while (l < r) {
            long mid = l + r >> 1;
            if (mid * mid < x) l = mid + 1;
            else r = mid;
        }
        if (l * l > x) {
            return (int) l - 1;
        }
        return (int) l;
    }
}
