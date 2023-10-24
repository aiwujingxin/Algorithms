package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/24 12:09
 */
public class LeetCode69 {

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
