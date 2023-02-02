package leetcode.plan.algorithm.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:14
 */
public class LeetCode278 {

    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }
        int l = 0;
        int r = n;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (isBadVersion(l)) {
            return l;
        }
        return r;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
