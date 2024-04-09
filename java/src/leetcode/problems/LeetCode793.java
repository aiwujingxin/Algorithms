package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/12 16:32
 */
public class LeetCode793 {

    public int preimageSizeFZF(int k) {
        if (k == 0) {
            return 5;
        }
        long a = leftBound(k + 1);
        long b = rightBound(k - 1);
        return (int) (a - b - 1);
    }

    private long leftBound(int target) {
        long l = 0;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + r >> 1;
            if (trailingZeroes(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private long rightBound(int target) {
        long l = 0;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (trailingZeroes(mid) > target) r = mid - 1;
            else l = mid;
        }
        return l;
    }

    public long trailingZeroes(long n) {
        long ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
