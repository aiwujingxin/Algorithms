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
        long a = search1(k + 1);
        long b = search2(k - 1);
        return (int) (a - b - 1);
    }

    private long search1(int target) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            if (trailingZeroes(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long search2(int target) {
        long left = 0;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (right - left) / 2 + left + 1;
            if (trailingZeroes(mid) > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return left;
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
