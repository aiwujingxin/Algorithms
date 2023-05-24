package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/19 18:13
 */
public class LeetCode793 {

    public int preimageSizeFZF(int k) {
        return (int) (help(k + 1) - help(k));
    }

    public long help(int k) {
        long r = 5L * k;
        long l = 0;
        while (l < r) {
            long mid = (l + r) / 2;
            if (trailingZeroes(mid) >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
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
