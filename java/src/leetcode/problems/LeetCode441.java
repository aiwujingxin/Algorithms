package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/1 16:35
 */
public class LeetCode441 {

    public int arrangeCoins(int n) {
        if (n == 1) {
            return 1;
        }
        long left = 1;
        long right = n;
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid) <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left - 1;
    }

    private long check(long mid) {
        return (1 + mid) * mid / 2;
    }
}
