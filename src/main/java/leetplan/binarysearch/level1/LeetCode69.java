package leetplan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/8 21:34
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int l = 0;
        int r = x;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return (int) mid;
            }
            if (mid * mid < x) {
                l = (int) mid + 1;
            } else {
                r = (int) mid - 1;
            }
        }
        return r;
    }
}
