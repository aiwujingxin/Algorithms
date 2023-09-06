package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/6 22:24
 */
public class LeetCode1802 {

    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid, n, index, maxSum)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public boolean check(int x, int n, int index, int maxSum) {
        double l = cal(x, index + 1);
        double r = cal(x, n - index);
        return l + r - x <= maxSum;
    }

    public double cal(int x, int len) {
        if (x > len) {
            int bound = x - len + 1;
            return (double) (bound + x) / 2 * (double) len;
        }
        int cnt = Math.max(0, len - x);
        return (double) (long) (1 + x) / 2 * x + cnt;
    }
}
