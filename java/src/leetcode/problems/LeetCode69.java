package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 21:34
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            long mid = ((right - left) / 2 + left + 1) >> 1;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                left = (int) mid;
            } else {
                right = (int) mid - 1;
            }
        }
        return left;
    }
}
