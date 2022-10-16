package leetplan.binarysearch.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 14:43
 */
public class LeetCode441 {

    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        long l = 1;
        long r = n;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long total = mid * (mid + 1) / 2;
            if (total == n) {
                return (int) mid;
            }
            if (total > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }
}
