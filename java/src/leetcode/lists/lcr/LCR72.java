package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 18:09
 */
public class LCR72 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long left = 0;
        long right = x;
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                left = (int) mid;
            } else {
                right = (int) mid - 1;
            }
        }
        return (int) left;
    }
}


