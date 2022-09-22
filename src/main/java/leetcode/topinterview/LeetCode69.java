package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 02:10
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
